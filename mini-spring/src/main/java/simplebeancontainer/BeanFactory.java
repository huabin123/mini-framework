package simplebeancontainer;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanFactory
 */
public class BeanFactory {

    private Map<String, Object> beanMap = new HashMap<String, Object>();  // 容器

    public void registerBean(String name, Object bean){
        beanMap.put(name, bean);
    }

    public Object getBean(String name){
        return beanMap.get(name);
    }
}
