package populatebeanwithbean;

import org.junit.Test;
import populatebeanwithbean.bean.Car;
import populatebeanwithbean.beans.factory.PropertyValue;
import populatebeanwithbean.beans.factory.PropertyValues;
import populatebeanwithbean.beans.factory.config.BeanDefinition;
import populatebeanwithbean.beans.factory.config.BeanReference;
import populatebeanwithbean.beans.factory.support.DefaultListableBeanFactory;
import populatebeanwithpropertyvalues.bean.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-11-30 16:40
 * @Desc
 */
public class PopulateBeanWithBeanTest {

    /**
     * 为bean注入bean
     */
    @Test
    public void testPopulateBeanWithBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册Car实例
        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand", "porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
        beanFactory.registerBeanDefinition("car", carBeanDefinition);

        // 注册Person实例
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", "18"));
        // Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        BeanDefinition personBeanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person", personBeanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("derek");
        assertThat(person.getAge()).isEqualTo("18");
        Car car = person.getCar();
        assertThat(car).isNotNull();
        assertThat(car.getBrand()).isEqualTo("porsche");

    }

}
