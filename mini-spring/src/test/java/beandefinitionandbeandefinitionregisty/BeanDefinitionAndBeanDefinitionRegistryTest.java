package beandefinitionandbeandefinitionregisty;

import beandefinitionandbeandefinitionregisty.beans.factory.config.BeanDefinition;
import beandefinitionandbeandefinitionregisty.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-11-30 09:36
 * @Desc
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }

}
