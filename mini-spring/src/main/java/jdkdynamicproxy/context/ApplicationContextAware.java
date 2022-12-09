package jdkdynamicproxy.context;

import jdkdynamicproxy.beans.BeansException;
import jdkdynamicproxy.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
