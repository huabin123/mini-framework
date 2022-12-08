package pointcutexpression.context;

import pointcutexpression.beans.BeansException;
import pointcutexpression.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
