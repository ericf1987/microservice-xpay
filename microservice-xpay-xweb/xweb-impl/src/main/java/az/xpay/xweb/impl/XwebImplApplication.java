package az.xpay.xweb.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 9:52
 */
@SpringBootApplication
@PropertySource("classpath:application-base.yml")
@Slf4j
public class XwebImplApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(XwebImplApplication.class);
        app.run(args);

        showBeanSummary();

    }

    private static void showBeanSummary() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("az.xpay");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            log.info("组件列表：{}", definitionName);
        }

    }

}
