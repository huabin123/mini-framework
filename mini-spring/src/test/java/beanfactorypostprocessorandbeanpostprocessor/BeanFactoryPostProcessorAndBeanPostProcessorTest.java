package beanfactorypostprocessorandbeanpostprocessor;

import beanfactorypostprocessorandbeanpostprocessor.bean.Car;
import beanfactorypostprocessorandbeanpostprocessor.bean.Person;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.support.DefaultListableBeanFactory;
import beanfactorypostprocessorandbeanpostprocessor.beans.factory.xml.XmlBeanDefinitionReader;
import beanfactorypostprocessorandbeanpostprocessor.common.CustomBeanFactoryPostProcessor;
import beanfactorypostprocessorandbeanpostprocessor.common.CustomBeanPostProcessor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @Author huabin
 * @DateTime 2022-12-02 14:46
 * @Desc
 */
public class BeanFactoryPostProcessorAndBeanPostProcessorTest {

    @Test
    public void testBeanFactoryPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring-postprocessor.xml");

        // 在所有BeanDefinition加载完成后，但在初始化之前，修改BeanDefinition的属性值
        CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
        customBeanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        Person person = (Person)beanFactory.getBean("person");
        System.out.println(person);
        // name属性在CustomBeanFactoryPostProcessor中被修改为ice
        assertThat(person.getName()).isEqualTo("ice");
    }

    @Test
    public void testBeanPostProcessor() throws IOException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring-postprocessor.xml");

        // 添加bean实例化后的处理器
        CustomBeanPostProcessor customBeanPostProcessor = new CustomBeanPostProcessor();
        beanFactory.addBeanPostProcessor(customBeanPostProcessor);

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        //brand属性在CustomerBeanPostProcessor中被修改为lamborghini
        Assertions.assertThat(car.getBrand()).isEqualTo("lamborghini");
    }

}
