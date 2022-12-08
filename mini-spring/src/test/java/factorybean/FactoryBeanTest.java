package factorybean;

import factorybean.bean.Car;
import factorybean.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-07 22:01
 * @Desc
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("porsche");
    }

}
