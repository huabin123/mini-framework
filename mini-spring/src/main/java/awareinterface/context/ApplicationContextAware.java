package awareinterface.context;

import awareinterface.beans.BeansException;
import awareinterface.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
