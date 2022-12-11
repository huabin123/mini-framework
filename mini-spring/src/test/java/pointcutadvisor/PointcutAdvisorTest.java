package pointcutadvisor;

import org.aopalliance.intercept.MethodInterceptor;
import pointcutadvisor.aop.AdvisedSupport;
import pointcutadvisor.aop.ClassFilter;
import pointcutadvisor.aop.MethodMatcher;
import pointcutadvisor.aop.TargetSource;
import pointcutadvisor.aop.aspectj.AspectJExpressionPointcut;
import pointcutadvisor.aop.aspectj.AspectJExpressionPointcutAdvisor;
import pointcutadvisor.aop.framework.CglibAopProxy;
import pointcutadvisor.aop.framework.JdkDynamicAopProxy;
import pointcutadvisor.aop.framework.ProxyFactory;
import pointcutadvisor.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import pointcutadvisor.common.WorldServiceBeforeAdvice;
import pointcutadvisor.common.WorldServiceInterceptor;
import pointcutadvisor.service.WorldService;
import pointcutadvisor.service.WorldServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-12-11 10:21
 * @Desc
 */
public class PointcutAdvisorTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* pointcutadvisor.service.WorldService.explode(..))").getMethodMatcher();
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
    public void testpointcutadvisor(){
        // 设置BeforeAdvice
        WorldServiceBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor(){
        WorldService worldService = new WorldServiceImpl();

        // Advisor是Pointcut和Advice的组合
        String expression = "execution(* pointcutadvisor.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        advisor.setAdvice(methodBeforeAdviceInterceptor);

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

            WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
            proxy.explode();
        }
    }

}
