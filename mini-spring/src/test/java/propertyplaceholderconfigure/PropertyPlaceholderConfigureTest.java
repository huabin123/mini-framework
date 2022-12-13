package propertyplaceholderconfigure;

import org.junit.Test;
import propertyplaceholderconfigure.bean.Car;
import propertyplaceholderconfigure.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-13 06:59
 * @Desc
 */
public class PropertyPlaceholderConfigureTest {

    @Test
    public void testPropertyPlaceholderConfigure() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder-configurer.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }

}
