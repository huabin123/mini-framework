package proxyfactory;

import org.junit.Before;
import org.junit.Test;
import proxyfactory.aop.AdvisedSupport;
import proxyfactory.aop.MethodMatcher;
import proxyfactory.aop.TargetSource;
import proxyfactory.aop.aspectj.AspectJExpressionPointcut;
import proxyfactory.aop.framework.CglibAopProxy;
import proxyfactory.aop.framework.JdkDynamicAopProxy;
import proxyfactory.aop.framework.ProxyFactory;
import proxyfactory.common.WorldServiceInterceptor;
import proxyfactory.service.WorldService;
import proxyfactory.service.WorldServiceImpl;

/**
 * @Author huabin
 * @DateTime 2022-12-09 15:14
 * @Desc
 */
public class ProxyFactoryTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* proxyfactory.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCglibDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testProxyFactory(){
        // 使用JDK动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();

        // 使用CGLIB动态代理
        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }


}
