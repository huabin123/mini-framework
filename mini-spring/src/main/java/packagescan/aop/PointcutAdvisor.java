package packagescan.aop;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
