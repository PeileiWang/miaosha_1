package com.miaosha.miaosha.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by WangPeilei
 * Time 2018/9/22 19:21
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "dataSource")
    public DataSource druidDataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        /*配置初始化大小、最小、最大*/
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);

        /*配置获取连接等待超时的时间*/
        druidDataSource.setMaxWait(60000);

        /*配置间隔对酒进行一次检测，检测需要关闭的空闲连接*/
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);

        //最小生存时间
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);

        druidDataSource.setPoolPreparedStatements(false);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

        /* 配置监控统计拦截的filters */
        druidDataSource.setFilters("stat,wall,log4j");
        return druidDataSource;
    }
}
