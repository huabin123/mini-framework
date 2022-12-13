package circularreferencewithproxybean.beans.factory;

import circularreferencewithproxybean.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
