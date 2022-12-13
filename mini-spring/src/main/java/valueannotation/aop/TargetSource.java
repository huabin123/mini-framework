package valueannotation.aop;

/**
 * @Author huabin
 * @DateTime 2022-12-09 13:11
 * @Desc
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
