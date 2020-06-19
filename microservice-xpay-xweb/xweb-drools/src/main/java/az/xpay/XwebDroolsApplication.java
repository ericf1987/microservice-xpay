package az.xpay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/6/17 19:12
 */
@SpringBootApplication
@PropertySource("classpath:application-base.yml")
@Slf4j
public class XwebDroolsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(XwebDroolsApplication.class);
        app.run(args);
    }

}
