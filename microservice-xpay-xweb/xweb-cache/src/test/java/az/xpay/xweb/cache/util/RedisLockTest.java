package az.xpay.xweb.cache.util;

import az.xpay.XwebCacheBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static az.xpay.xweb.cache.util.RedisLock.DEFAULT_EXPIRE;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/5 11:24
 */
@Slf4j
class RedisLockTest extends XwebCacheBaseTest {

    @Autowired
    RedisLock redisLock;

    @Test
    void test1(){
        new Thread(() -> {
            boolean lock_flag = redisLock.lock0("lock_flag", DEFAULT_EXPIRE);
            log.info("当前线程 -> {}, 是否获取锁：{}", Thread.currentThread().getName(), lock_flag);
        }).start();

        new Thread(() -> {
            boolean lock_flag = redisLock.lock0("lock_flag", DEFAULT_EXPIRE);
            log.info("当前线程 -> {}, 是否获取锁：{}", Thread.currentThread().getName(), lock_flag);
        }).start();

        new Thread(() -> {
            boolean lock_flag = redisLock.lock0("lock_flag", DEFAULT_EXPIRE);
            log.info("当前线程 -> {}, 是否获取锁：{}", Thread.currentThread().getName(), lock_flag);
        }).start();
    }

}