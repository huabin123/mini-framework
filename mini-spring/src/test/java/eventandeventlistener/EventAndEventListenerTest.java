package eventandeventlistener;

import eventandeventlistener.common.event.CustomEvent;
import eventandeventlistener.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-12-08 13:00
 * @Desc
 */
public class EventAndEventListenerTest {

    @Test
    public void testEventAndEventListener(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");

        // 发布事件
        applicationContext.publishEvent(new CustomEvent(applicationContext));
        applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;

    }

}
