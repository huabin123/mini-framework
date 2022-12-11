package autoproxy.beans.factory;

import autoproxy.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
