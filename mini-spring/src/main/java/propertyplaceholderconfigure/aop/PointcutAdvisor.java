package propertyplaceholderconfigure.aop;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
