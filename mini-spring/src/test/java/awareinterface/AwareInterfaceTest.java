package awareinterface;

import awareinterface.context.support.ClassPathXmlApplicationContext;
import awareinterface.service.HelloService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-07 11:11
 * @Desc
 */
public class AwareInterfaceTest {

    @Test
    public void testAwareInterface() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aware-interface.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        assertThat(helloService.getApplicationContext()).isNotNull();
        assertThat(helloService.getBeanFactory()).isNotNull();
    }

}
