package circularreferencewithoutproxybean;

import circularreferencewithoutproxybean.bean.A;
import circularreferencewithoutproxybean.bean.B;
import circularreferencewithoutproxybean.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-13 16:26
 * @Desc
 */
public class CircularReferenceWithoutProxyBeanTest {

    @Test
    public void testCircularReference() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-reference-without-proxy-bean.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);
        assertThat(a.getB() == b).isTrue();
    }

}
