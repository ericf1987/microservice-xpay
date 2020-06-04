package az.xpay.xweb.cache.service;

import az.xpay.xweb.api.domain.device.DeviceDM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/4 15:08
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ValueOperations<String, Object> valueOperations;

    public void test(){
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        DeviceDM deviceDM = new DeviceDM().setId("100").setDeviceName("终端设备100").setNickName("zd100").setUniqueCode("zd100");
        String key = "device_" + deviceDM.getId();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(!hasKey){
            valueOperations.set("device", deviceDM, 100, TimeUnit.SECONDS);
            log.info("写入缓存：key -> {}", key);
        }else{
            DeviceDM d = (DeviceDM)valueOperations.get(key);
            log.info("读取缓存：device -> {}", d.toString());
        }

    }

}
