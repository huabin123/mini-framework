package resourceandresourceloader;

import cn.hutool.core.io.IoUtil;
import org.junit.Test;
import resourceandresourceloader.core.io.DefaultResourceLoader;
import resourceandresourceloader.core.io.FileSystemResource;
import resourceandresourceloader.core.io.Resource;
import resourceandresourceloader.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-01 09:30
 * @Desc
 */
public class ResourceAndResourceLoaderTest {

    @Test
    public void testResourceAndResourceLoader() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // 加载classpath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertThat(content).isEqualTo("hello world");

        // 加载文件系统资源
        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        assertThat(resource instanceof FileSystemResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assertThat(content).isEqualTo("hello world");

        // 加载远程url系统资源
        resource = resourceLoader.getResource("https://github.com/DerekYRC/mini-spring/blob/main/README.md");
        assertThat(resource instanceof UrlResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

}
