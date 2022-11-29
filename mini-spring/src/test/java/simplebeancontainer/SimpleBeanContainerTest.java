package simplebeancontainer;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class SimpleBeanContainerTest {

    @Test
    public void testGetBean(){
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("hello", new HelloService());
        HelloService hello = (HelloService) beanFactory.getBean("hello");
        assertThat(hello).isNotNull();
        assertThat(hello.sayHello()).isEqualTo("hello");
    }

    class HelloService{
        public String sayHello(){
            System.out.println("hello");
            return "hello";
        }
    }

}
