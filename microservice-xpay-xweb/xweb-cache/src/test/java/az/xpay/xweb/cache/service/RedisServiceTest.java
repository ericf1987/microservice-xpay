package az.xpay.xweb.cache.service;

import az.xpay.XwebCacheBaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/4 15:17
 */
class RedisServiceTest extends XwebCacheBaseTest {

    @Autowired
    RedisService redisService;

    @Test
    void test1() {
        redisService.test();
    }
}