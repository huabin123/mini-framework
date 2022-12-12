package propertyplaceholderconfigure.beans.factory.config;


import propertyplaceholderconfigure.beans.BeansException;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

	/**
	 * 在bean实例化之前执行
	 *
	 * @param beanClass
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
