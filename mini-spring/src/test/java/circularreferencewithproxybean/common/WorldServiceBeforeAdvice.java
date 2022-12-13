package circularreferencewithproxybean.common;

import circularreferencewithproxybean.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author huabin
 * @DateTime 2022-12-09 21:52
 * @Desc
 */
public class WorldServiceBeforeAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice: do something before the earth explodes");
    }

}
