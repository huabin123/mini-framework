package commonadvice.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
