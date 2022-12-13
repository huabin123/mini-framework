package populateproxybeanwithpropertyvalues;

import org.junit.Test;
import populateproxybeanwithpropertyvalues.context.support.ClassPathXmlApplicationContext;
import populateproxybeanwithpropertyvalues.service.WorldService;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-13 14:17
 * @Desc
 */
public class AutoProxyTest {

    @Test
    public void testPopulateProxyBeanWithPropertyValues() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:populate-proxy-bean-with-property-values.xml");

        //获取代理对象
        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        worldService.explode();
        assertThat(worldService.getName()).isEqualTo("earth");
    }

}
