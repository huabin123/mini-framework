package applicationcontext;

import applicationcontext.bean.Car;
import applicationcontext.bean.Person;
import applicationcontext.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-05 09:26
 * @Desc
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-applicationcontext.xml");

        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
        //name属性在CustomBeanFactoryPostProcessor中被修改为ivy
        assertThat(person.getName()).isEqualTo("ivy");

        Car car = applicationContext.getBean("car", Car.class);
        System.out.println(car);
        //brand属性在CustomerBeanPostProcessor中被修改为lamborghini
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }

}
