package circularreferencewithoutproxybean.beans.factory;

import circularreferencewithoutproxybean.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
