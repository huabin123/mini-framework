package propertyplaceholderconfigure.beans.factory;

import propertyplaceholderconfigure.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
