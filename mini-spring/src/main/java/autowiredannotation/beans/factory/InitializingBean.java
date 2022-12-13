package autowiredannotation.beans.factory;

import autowiredannotation.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
