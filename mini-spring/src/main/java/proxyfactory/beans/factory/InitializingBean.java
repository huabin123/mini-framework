package proxyfactory.beans.factory;

import proxyfactory.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
