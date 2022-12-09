package proxyfactory.aop;

/**
 * 切点抽象
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
