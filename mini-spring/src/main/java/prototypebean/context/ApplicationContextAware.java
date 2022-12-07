package prototypebean.context;

import prototypebean.beans.BeansException;
import prototypebean.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
