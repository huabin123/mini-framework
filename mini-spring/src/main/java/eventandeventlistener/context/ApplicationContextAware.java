package eventandeventlistener.context;

import eventandeventlistener.beans.BeansException;
import eventandeventlistener.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
