package propertyplaceholderconfigure.context;

import propertyplaceholderconfigure.beans.BeansException;
import propertyplaceholderconfigure.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
