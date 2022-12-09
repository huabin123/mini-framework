package jdkdynamicproxy.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
