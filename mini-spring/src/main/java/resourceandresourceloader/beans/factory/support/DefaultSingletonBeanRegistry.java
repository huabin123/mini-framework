package resourceandresourceloader.beans.factory.support;

import resourceandresourceloader.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huabin
 * @DateTime 2022-11-30 10:02
 * @Desc
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    protected void addSingleton(String name, Object singletonObject) {
        singletonObjects.put(name, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }
}
