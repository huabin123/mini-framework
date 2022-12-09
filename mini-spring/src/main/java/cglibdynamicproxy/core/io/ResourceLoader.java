package cglibdynamicproxy.core.io;

import cglibdynamicproxy.beans.BeansException;


/**
 * 资源加载器接口
 */
public interface ResourceLoader {

    Resource getResource(String location) throws BeansException;

}
