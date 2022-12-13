package packagescan.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
