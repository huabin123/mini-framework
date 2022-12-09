package pointcutexpression;

import org.junit.Test;
import pointcutexpression.aop.aspectj.AspectJExpressionPointCut;
import pointcutexpression.service.HelloService;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-08 21:40
 * @Desc
 */
public class PointcutExpressionTest {
    @Test
    public void testPointcutExpression() throws NoSuchMethodException {
        AspectJExpressionPointCut pointcut = new AspectJExpressionPointCut("execution(* pointcutexpression.service.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;

        Method method = clazz.getDeclaredMethod("sayHello");

        assertThat(pointcut.matches(clazz)).isTrue();
        assertThat(pointcut.matches(method, clazz)).isTrue();

    }
}
