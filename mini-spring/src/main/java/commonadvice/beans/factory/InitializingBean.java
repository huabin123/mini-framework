package commonadvice.beans.factory;

import commonadvice.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
