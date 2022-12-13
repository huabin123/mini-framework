package populateproxybeanwithpropertyvalues.context;

import populateproxybeanwithpropertyvalues.beans.BeansException;
import populateproxybeanwithpropertyvalues.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
