package az.xpay.xweb.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/4 15:09
 */
@SpringBootApplication
@PropertySource("classpath:application-base.yml")
@Slf4j
public class XwebCacheApplication {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(XwebCacheApplication.class);
        app.run(args);

    }
}
