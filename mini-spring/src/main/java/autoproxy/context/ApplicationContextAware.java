package autoproxy.context;

import autoproxy.beans.BeansException;
import autoproxy.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
