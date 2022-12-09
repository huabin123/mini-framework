package commonadvice.context;

import commonadvice.beans.BeansException;
import commonadvice.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
