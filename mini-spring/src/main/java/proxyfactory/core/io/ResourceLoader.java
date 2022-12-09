package proxyfactory.core.io;

import proxyfactory.beans.BeansException;


/**
 * 资源加载器接口
 */
public interface ResourceLoader {

    Resource getResource(String location) throws BeansException;

}
