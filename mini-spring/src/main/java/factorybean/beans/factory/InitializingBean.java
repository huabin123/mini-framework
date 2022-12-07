package factorybean.beans.factory;

import factorybean.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
