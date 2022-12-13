package packagescan.aop.aspectj;

import org.aopalliance.aop.Advice;
import packagescan.aop.Pointcut;
import packagescan.aop.PointcutAdvisor;

/**
 * @Author huabin
 * @DateTime 2022-12-11 10:31
 * @Desc aspectJ表达式的advisor
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private Advice advice;

    private AspectJExpressionPointcut pointcut;

    private String expression;

    public void setExpression(String expression){
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice){
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
