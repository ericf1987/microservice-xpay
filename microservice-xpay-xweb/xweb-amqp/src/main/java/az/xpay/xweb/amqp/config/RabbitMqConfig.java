package az.xpay.xweb.amqp.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * rabbit mq 配置类
 *
 * @author Eric F
 * @version 1.0
 * @date 2020/6/16 17:45
 */
@Configuration
@PropertySource("classpath:application-base.yml")
@ConfigurationProperties(prefix = "spring.rabbitmq")
@Data
@Slf4j
public class RabbitMqConfig {

    public static final String EXCHANGE_NAME = "queue_exchange";

    public static final String QUEUE_NAME = "queue";

    public static final String ROUTE_KEY = "queue_route_key";

//    @Value("${spring.rabbitmq.host}")
    private String host;

//    @Value("${spring.rabbitmq.port}")
    private String port;

//    @Value("${spring.rabbitmq.username}")
    private String username;

//    @Value("${spring.rabbitmq.password}")
    private String password;

//    @Value("${spring.rabbitmq.virtualHost}")
    private String virtualHost;

    @Bean
    public static PropertySourcesPlaceholderConfigurer ymlProperties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application-base.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }


    @Bean
    public ConnectionFactory amqpConnectionFactory() {
        CachingConnectionFactory ccf = new CachingConnectionFactory();
        ccf.setAddresses(host + ":" + port);
        ccf.setUsername(username);
        ccf.setPassword(password);
        ccf.setVirtualHost("/");
        ccf.setPublisherReturns(true);
        return ccf;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory cf) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cf);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            if (ack) {
                log.info("消息发送到exchange失败！cause {}, dataId {}", cause, data.getId().toLowerCase());
            }
            //开启强制委托模式
            rabbitTemplate.setMandatory(true);
            rabbitTemplate.setReturnCallback(((message, replyCode, replyText, exchange, routingKey) -> {
                log.info("消息发送到queue失败! ReturnCallback:{},{},{},{},{},{}", message.getBody(), replyCode, replyText, exchange, routingKey);
            }));

        });
        return rabbitTemplate;
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory cf) {
        SimpleRabbitListenerContainerFactory lcf = new SimpleRabbitListenerContainerFactory();
        lcf.setConnectionFactory(cf);
        lcf.setMessageConverter(new Jackson2JsonMessageConverter());
        return lcf;
    }

}
