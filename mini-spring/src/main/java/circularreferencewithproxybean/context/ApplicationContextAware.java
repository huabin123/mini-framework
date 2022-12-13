package circularreferencewithproxybean.context;

import circularreferencewithproxybean.beans.BeansException;
import circularreferencewithproxybean.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
