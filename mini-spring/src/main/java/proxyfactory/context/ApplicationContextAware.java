package proxyfactory.context;

import proxyfactory.beans.BeansException;
import proxyfactory.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
