package circularreferencewithproxybean.beans.factory;


import circularreferencewithproxybean.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface DisposableBean {

    void destroy() throws BeansException, InvocationTargetException, IllegalAccessException;

}
