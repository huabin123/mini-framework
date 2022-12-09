package cglibdynamicproxy.context;

import cglibdynamicproxy.beans.BeansException;
import cglibdynamicproxy.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
