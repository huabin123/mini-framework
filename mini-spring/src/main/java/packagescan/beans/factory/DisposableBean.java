package packagescan.beans.factory;


import packagescan.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

public interface DisposableBean {

    void destroy() throws BeansException, InvocationTargetException, IllegalAccessException;

}
