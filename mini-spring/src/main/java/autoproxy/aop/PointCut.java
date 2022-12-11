package autoproxy.aop;

/**
 * 切点抽象
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
