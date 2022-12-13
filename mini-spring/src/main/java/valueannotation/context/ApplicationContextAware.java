package valueannotation.context;

import valueannotation.beans.BeansException;
import valueannotation.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
