package valueannotation;

import org.junit.Test;
import valueannotation.bean.Car;
import valueannotation.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-13 10:54
 * @Desc
 */
public class ValueAnnotationTest {

    @Test
    public void testValueAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:value-annotation.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }

}
