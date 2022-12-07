package factorybean.context;

import factorybean.beans.BeansException;
import factorybean.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
