package cglibdynamicproxy;

import cglibdynamicproxy.aop.AdvisedSupport;
import cglibdynamicproxy.aop.MethodMatcher;
import cglibdynamicproxy.aop.TargetSource;
import cglibdynamicproxy.aop.aspectj.AspectJExpressionPointCut;
import cglibdynamicproxy.aop.framework.CglibDynamicProxy;
import cglibdynamicproxy.common.WorldServiceInterceptor;
import cglibdynamicproxy.service.WorldService;
import cglibdynamicproxy.service.WorldServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-12-09 13:59
 * @Desc
 */
public class CglibAopProxyTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setUp(){
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointCut("execution(* cglibdynamicproxy.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testCglibDynamicProxy(){
        WorldService proxy = (WorldService) new CglibDynamicProxy(advisedSupport).getProxy();
        proxy.explode();
    }

}
