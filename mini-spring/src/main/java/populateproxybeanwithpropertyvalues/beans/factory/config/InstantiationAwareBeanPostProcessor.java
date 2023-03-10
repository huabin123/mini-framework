package populateproxybeanwithpropertyvalues.beans.factory.config;


import populateproxybeanwithpropertyvalues.beans.BeansException;
import populateproxybeanwithpropertyvalues.beans.PropertyValues;

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

	/**
	 * bean实例化之后，设置属性之前执行
	 *
	 * @param pvs
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName)
            throws Exception;

	/**
	 * bean实例化之后，设置属性之前执行
	 *
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

}
