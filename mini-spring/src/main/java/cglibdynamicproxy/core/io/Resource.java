package cglibdynamicproxy.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源的抽象和获取接口
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
