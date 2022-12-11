package autoproxy;

import autoproxy.common.WorldServiceBeforeAdvice;
import autoproxy.common.WorldServiceInterceptor;
import autoproxy.service.WorldService;
import autoproxy.service.WorldServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;
import autoproxy.aop.AdvisedSupport;
import autoproxy.aop.MethodMatcher;
import autoproxy.aop.TargetSource;
import autoproxy.aop.aspectj.AspectJExpressionPointcut;
import autoproxy.aop.framework.CglibAopProxy;
import autoproxy.aop.framework.JdkDynamicAopProxy;
import autoproxy.aop.framework.ProxyFactory;
import autoproxy.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import pointcutadvisor.aop.ClassFilter;
import pointcutadvisor.aop.aspectj.AspectJExpressionPointcutAdvisor;

/**
 * @Author huabin
 * @DateTime 2022-12-11 10:21
 * @Desc
 */
public class AutoProxyTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* autoproxy.service.WorldService.explode(..))").getMethodMatcher();
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
    public void testautoproxy(){
        // 设置BeforeAdvice
        WorldServiceBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor(){
        pointcutadvisor.service.WorldService worldService = new pointcutadvisor.service.WorldServiceImpl();

        // Advisor是Pointcut和Advice的组合
        String expression = "execution(* pointcutadvisor.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        pointcutadvisor.aop.framework.adapter.MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new pointcutadvisor.aop.framework.adapter.MethodBeforeAdviceInterceptor(new pointcutadvisor.common.WorldServiceBeforeAdvice());
        advisor.setAdvice(methodBeforeAdviceInterceptor);

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())) {
            pointcutadvisor.aop.AdvisedSupport advisedSupport = new pointcutadvisor.aop.AdvisedSupport();

            pointcutadvisor.aop.TargetSource targetSource = new pointcutadvisor.aop.TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

            pointcutadvisor.service.WorldService proxy = (pointcutadvisor.service.WorldService) new pointcutadvisor.aop.framework.ProxyFactory(advisedSupport).getProxy();
            proxy.explode();
        }
    }

    @Test
    public void testAutoProxy(){

    }

}
