package circularreferencewithproxybean.beans.factory;


import circularreferencewithproxybean.beans.BeansException;

/**
 * @author derekyi
 * @date 2021/1/30
 */
public interface ObjectFactory<T> {

	T getObject() throws BeansException;
}
