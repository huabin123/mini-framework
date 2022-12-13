package autowiredannotation.common;

import autowiredannotation.bean.Car;
import autowiredannotation.beans.BeansException;
import autowiredannotation.beans.factory.config.BeanPostProcessor;

/**
 * @Author huabin
 * @DateTime 2022-12-05 08:09
 * @Desc
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization");
        //换兰博基尼
        if ("car".equals(beanName)) {
            ((Car) bean).setBrand("lamborghini");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization");
        return bean;
    }
}
