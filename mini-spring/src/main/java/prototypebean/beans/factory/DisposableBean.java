package prototypebean.beans.factory;


import prototypebean.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface DisposableBean {

    void destroy() throws BeansException, InvocationTargetException, IllegalAccessException;

}
