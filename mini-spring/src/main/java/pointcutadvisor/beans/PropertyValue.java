package pointcutadvisor.beans;

/**
 * @Author huabin
 * @DateTime 2022-11-30 15:02
 * @Desc bean属性信息
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
