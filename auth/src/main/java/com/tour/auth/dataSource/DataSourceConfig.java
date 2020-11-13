package com.tour.auth.dataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置2个数据源
 */
@Configuration
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /**
     * 写库 配置
     * @return
     */
    @Primary
    @Bean(name = "writeDataSource")
    @ConfigurationProperties(prefix = "datasource.write")
    public DataSource writeDataSource() {
        logger.info("[writeDataSource init]");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 读库 配置
     * @return
     */
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "datasource.read")
    public DataSource readDataSource() {
        logger.info("[readDataSource init]");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }


}
