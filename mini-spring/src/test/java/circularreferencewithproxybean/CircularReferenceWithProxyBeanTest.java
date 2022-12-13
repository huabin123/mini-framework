package circularreferencewithproxybean;

import circularreferencewithproxybean.bean.A;
import circularreferencewithproxybean.bean.B;
import circularreferencewithproxybean.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-13 16:26
 * @Desc
 */
public class CircularReferenceWithProxyBeanTest {

    @Test
    public void testCircularReference() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-with-proxy-bean.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);

        assertThat(b.getA() == a).isTrue();
    }

}
