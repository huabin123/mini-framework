package circularreferencewithoutproxybean.beans.factory;


import circularreferencewithoutproxybean.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface DisposableBean {

    void destroy() throws BeansException, InvocationTargetException, IllegalAccessException;

}
