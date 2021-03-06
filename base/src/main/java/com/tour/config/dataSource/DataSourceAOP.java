package com.tour.config.dataSource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class DataSourceAOP {

    private static Logger logger = LoggerFactory.getLogger(DataSourceAOP.class);

    @Before("@annotation(com.tour.config.dataSource.Read)")
    public void setReadDataSourceType() {
        //从spring容器当中取出read数据源来使用
        logger.info("[com.tour.base.dataSource 切换到: Read]");
        DynamicDataSourceHolder.change2Read();
    }

    @Before("@annotation(com.tour.config.dataSource.Write)")
    public void setWriteDataSourceType() {
        //从Spring容器当中取出write数据源来使用
        logger.info("[com.tour.base.dataSource 切换到: Write]");
        DynamicDataSourceHolder.change2Write();
    }

}
