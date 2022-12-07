package prototypebean.beans.factory;

import prototypebean.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
