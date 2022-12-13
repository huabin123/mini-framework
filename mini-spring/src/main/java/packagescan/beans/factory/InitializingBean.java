package packagescan.beans.factory;

import packagescan.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
