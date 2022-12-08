package pointcutexpression.beans.factory;

import pointcutexpression.beans.BeansException;

public interface InitializingBean {

    void afterPropertiesSet() throws BeansException;

}
