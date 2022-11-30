package populatebeanwithpropertyvalues;

import org.junit.Test;
import populatebeanwithpropertyvalues.bean.Person;
import populatebeanwithpropertyvalues.beans.factory.PropertyValue;
import populatebeanwithpropertyvalues.beans.factory.PropertyValues;
import populatebeanwithpropertyvalues.beans.factory.config.BeanDefinition;
import populatebeanwithpropertyvalues.beans.factory.support.DefaultListableBeanFactory;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-11-30 14:07
 * @Desc
 */
public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "curry"));
        propertyValues.addPropertyValue(new PropertyValue("age", "35"));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person)beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("curry");
        assertThat(person.getAge()).isEqualTo("35");
    }

}
