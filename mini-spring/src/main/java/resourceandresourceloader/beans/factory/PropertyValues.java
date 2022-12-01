package resourceandresourceloader.beans.factory;

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
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

}
