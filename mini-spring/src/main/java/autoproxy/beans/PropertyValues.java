package autoproxy.beans;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huabin
 * @DateTime 2022-11-30 15:11
 * @Desc
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue curProp = this.propertyValueList.get(i);
            if (StrUtil.equals(curProp.getName(), propertyValue.getName())) {
                // 覆盖原有的值
                this.propertyValueList.set(i, propertyValue);
                return;
            }
        }
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

}
