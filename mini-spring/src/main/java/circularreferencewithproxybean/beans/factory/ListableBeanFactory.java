package circularreferencewithproxybean.beans.factory;

import java.util.Map;

/**
 * 【新增接口】
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 返回指定类型的所有实例
     * @param type
     * @return
     * @param <T>
     */
    <T> Map<String, T> getBeansOfType(Class<T> type);

    /**
     * 返回定义的所有bean的名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
