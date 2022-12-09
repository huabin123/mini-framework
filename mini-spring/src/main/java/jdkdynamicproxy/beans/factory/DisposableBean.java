package jdkdynamicproxy.beans.factory;


import jdkdynamicproxy.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface DisposableBean {

    void destroy() throws BeansException, InvocationTargetException, IllegalAccessException;

}
