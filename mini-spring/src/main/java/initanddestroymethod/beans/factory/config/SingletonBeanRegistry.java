package initanddestroymethod.beans.factory.config;

/**
 * @Author huabin
 * @DateTime 2022-11-30 11:11
 * @Desc
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
