package autoproxy.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
