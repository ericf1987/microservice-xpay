package az.xpay.xweb.impl.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 9:45
 */
@Configuration
@PropertySource("classpath:application-base.yml")
@MapperScan("az.xpay.xweb.impl.impl.mapper")
@Data
@Slf4j
public class BaseDatasourceConfig {
    @Value("${base.datasource.url}")
    private String url;

    @Value("${base.datasource.username}")
    private String username;

    @Value("${base.datasource.password}")
    private String password;

    @Value("${base.datasource.driver}")
    private String driver;

    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Bean
    public static PropertySourcesPlaceholderConfigurer ymlProperties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application-base.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public DataSource baseDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager sqlTransactionManager(){
        return new DataSourceTransactionManager(baseDataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("baseDataSource") DataSource baseDataSource) throws Exception{
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(baseDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(this.mapperLocations);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);
        factoryBean.setMapperLocations(resources);
        return factoryBean.getObject();
    }

}
