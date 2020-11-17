package com.tour.base.mybatis;

import com.github.pagehelper.PageHelper;
import com.tour.base.dataSource.DataSourceConfig;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@AutoConfigureAfter({DataSourceConfig.class})
public class MybatisConfig {

    private static Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("multiDataSource")DataSource mds) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(mds);
        factoryBean.setPlugins(new Interceptor[]{pageHelperInterceptor()});
        return factoryBean.getObject();
    }

    @Bean
    public PageHelper pageHelperInterceptor() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("supportMethodsArguments", "true");
        p.setProperty("params", "pageNum=pageNum;pageSize=pageSize");
        pageHelper.setProperties(p);
        return pageHelper;
    }

}
