package commonadvice;

import commonadvice.aop.AdvisedSupport;
import commonadvice.aop.MethodMatcher;
import commonadvice.aop.TargetSource;
import commonadvice.aop.aspectj.AspectJExpressionPointcut;
import commonadvice.aop.framework.CglibAopProxy;
import commonadvice.aop.framework.JdkDynamicAopProxy;
import commonadvice.aop.framework.ProxyFactory;
import commonadvice.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import commonadvice.common.WorldServiceBeforeAdvice;
import commonadvice.common.WorldServiceInterceptor;
import commonadvice.service.WorldService;
import commonadvice.service.WorldServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-12-09 21:35
 * @Desc
 */
public class CommonAdviceTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* commonadvice.service.WorldService.explode(..))").getMethodMatcher();
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
    public void testProxyFactory() throws Exception {
        // 使用JDK动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();

        // 使用CGLIB动态代理
        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCommonAdvice(){
        // 设置BeforeAdvice
        WorldServiceBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

}
