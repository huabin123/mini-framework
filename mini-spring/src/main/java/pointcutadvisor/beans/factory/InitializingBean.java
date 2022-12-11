package pointcutadvisor.beans.factory;

import pointcutadvisor.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
