package initanddestroymethod.beans.factory;

import initanddestroymethod.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
