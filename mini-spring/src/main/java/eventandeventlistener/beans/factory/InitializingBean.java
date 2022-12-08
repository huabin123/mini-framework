package eventandeventlistener.beans.factory;

import eventandeventlistener.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
