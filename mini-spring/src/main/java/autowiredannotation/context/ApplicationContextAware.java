package autowiredannotation.context;

import autowiredannotation.beans.BeansException;
import autowiredannotation.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
