package valueannotation.beans.factory;

import valueannotation.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
