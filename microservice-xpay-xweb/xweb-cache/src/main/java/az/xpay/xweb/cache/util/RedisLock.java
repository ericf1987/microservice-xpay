package az.xpay.xweb.cache.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/5 10:02
 */
@Slf4j
@Component
public class RedisLock {

    //锁的超时时间
    public static final int DEFAULT_EXPIRE = 60;

    @Autowired
    ValueOperations<String, Object> valueOperations;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public boolean lock(String key, int expire) {
        //先进行设置
        Boolean result = valueOperations.setIfAbsent(key, "1");
        if (result) {
            //如果设置成功了 再设置超时时间
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
            return true;
        }

        return false;
    }

    public boolean lock(String key) {
        return lock(key, DEFAULT_EXPIRE);
    }

    public boolean lock0(String key, int expire) {
        long value = System.currentTimeMillis() + expire;
        //设置当前时间 + 超时时间
        Boolean result = valueOperations.setIfAbsent(key, String.valueOf(value));

        if (result) {
            return true;
        }

        //获取旧的超时时间
        long oldExpireTime = Long.parseLong(String.valueOf(valueOperations.get(key)));
        //超时
        if (oldExpireTime < System.currentTimeMillis()) {
            //新的超时时间
            long newExpireTime = System.currentTimeMillis() + expire;
            long currExpireTime = Long.parseLong(String.valueOf(valueOperations.getAndSet(key, newExpireTime)));
            //原来设置的时间和旧的超时时间相等 所以 是获取到锁了 不然 锁就是被其他线程占据了
            if (currExpireTime == oldExpireTime) {
                return true;
            }
        }
        return false;
    }

    public boolean unlock(String key) {
        return redisTemplate.delete(key);
    }

    public boolean unlockIfNotExpire(String key) {
        long oldExpireTime = Long.parseLong(String.valueOf(valueOperations.get(key)));
        if (oldExpireTime > System.currentTimeMillis()) {
            return redisTemplate.delete(key);
        }
        return false;
    }

    public void drawRedPacket(long userId) {
        String key = "draw.redpacket.userId:" + userId;

        boolean lock = lock0(key, DEFAULT_EXPIRE);

        if (lock) {
            try {
                //领取操作
            } finally {
                unlock(key);
            }
        } else {

        }

    }

}
