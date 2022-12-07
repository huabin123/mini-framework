package initanddestroymethod;

import initanddestroymethod.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-12-06 12:46
 * @Desc
 */
public class InitAndDestroyMethodTest {

    @Test
    public void testInitAndDestroyMethod(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        applicationContext.registerShutdownHook();  // 或者手动关闭 applicationContext.close()
    }

}
