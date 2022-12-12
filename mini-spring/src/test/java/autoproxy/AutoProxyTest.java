package autoproxy;

import autoproxy.context.support.ClassPathXmlApplicationContext;
import autoproxy.service.WorldService;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-12-11 10:21
 * @Desc
 */
public class AutoProxyTest {

    @Test
    public void testAutoProxy() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");

        //获取代理对象
        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        worldService.explode();
    }

}
