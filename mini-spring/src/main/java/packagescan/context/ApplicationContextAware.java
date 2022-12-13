package packagescan.context;

import packagescan.beans.BeansException;
import packagescan.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
