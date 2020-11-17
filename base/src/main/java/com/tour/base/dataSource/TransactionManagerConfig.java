package com.tour.base.dataSource;

import com.tour.base.mybatis.MybatisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter({MybatisConfig.class})
@EnableTransactionManagement
public class TransactionManagerConfig extends DataSourceTransactionManagerAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(TransactionManagerConfig.class);

    /**
     * mybatis自动参与到事务中，只要SqlSessionFactoryBean和DataSourceTransactionManager引用同一个数据源即可
     * @param mds
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("multiDataSource")DataSource mds) {
        logger.info("[transactionManager init]");
        return new DataSourceTransactionManager((mds));
    }

}
