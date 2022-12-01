package resourceandresourceloader.core.io;

import java.net.MalformedURLException;

/**
 * 资源加载器接口
 */
public interface ResourceLoader {

    Resource getResource(String location) throws MalformedURLException;

}
