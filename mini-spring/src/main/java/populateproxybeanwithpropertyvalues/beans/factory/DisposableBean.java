package populateproxybeanwithpropertyvalues.beans.factory;


import populateproxybeanwithpropertyvalues.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface DisposableBean {

    void destroy() throws BeansException, InvocationTargetException, IllegalAccessException;

}
