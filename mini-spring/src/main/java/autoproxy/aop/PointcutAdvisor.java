package autoproxy.aop;

public interface PointcutAdvisor extends Advisor {
    PointCut getPointcut();
}
