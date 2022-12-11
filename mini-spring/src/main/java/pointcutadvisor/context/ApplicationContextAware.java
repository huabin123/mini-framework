package pointcutadvisor.context;

import pointcutadvisor.beans.BeansException;
import pointcutadvisor.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
