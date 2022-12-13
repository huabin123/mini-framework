package populateproxybeanwithpropertyvalues.beans.factory;

import populateproxybeanwithpropertyvalues.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
