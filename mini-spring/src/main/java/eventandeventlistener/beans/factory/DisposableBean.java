package eventandeventlistener.beans.factory;


import eventandeventlistener.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface DisposableBean {

    void destroy() throws BeansException, InvocationTargetException, IllegalAccessException;

}
