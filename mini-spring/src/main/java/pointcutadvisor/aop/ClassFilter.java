package pointcutadvisor.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
