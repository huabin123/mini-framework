package pointcutadvisor.aop;

import org.aopalliance.aop.Advice;

public interface PointcutAdvisor extends Advisor{
    PointCut getPointcut();
}
