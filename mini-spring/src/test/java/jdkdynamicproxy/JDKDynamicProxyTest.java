package jdkdynamicproxy;

import jdkdynamicproxy.aop.AdvisedSupport;
import jdkdynamicproxy.aop.MethodMatcher;
import jdkdynamicproxy.aop.TargetSource;
import jdkdynamicproxy.aop.aspectj.AspectJExpressionPointCut;
import jdkdynamicproxy.aop.framework.JdkDynamicProxy;
import jdkdynamicproxy.common.WorldServiceInterceptor;
import jdkdynamicproxy.service.WorldService;
import jdkdynamicproxy.service.WorldServiceImpl;
import org.junit.Test;

/**
 * @Author huabin
 * @DateTime 2022-12-09 12:25
 * @Desc
 */
public class JDKDynamicProxyTest {

    @Test
    public void testJDKDynamicProxy(){
        WorldService worldService = new WorldServiceImpl();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointCut("execution(* jdkdynamicproxy.service.WorldService.explode(..))").getMethodMatcher();

        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);

        WorldService proxy = (WorldService) new JdkDynamicProxy(advisedSupport).getProxy();
        proxy.explode();
    }
}
