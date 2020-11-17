import com.alibaba.fastjson.JSONObject;
import com.tour.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void getBeanTest() {
//        Object dynamicDataSource = SpringUtil.getBean("readDataSource", DataSource.class);
//        System.out.println(dynamicDataSource);

        int beanCount = applicationContext.getBeanDefinitionCount();
        System.out.println(beanCount);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println(JSONObject.toJSONString(beanNames));
    }

}
