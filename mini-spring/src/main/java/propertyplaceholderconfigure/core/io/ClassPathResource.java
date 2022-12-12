package propertyplaceholderconfigure.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author huabin
 * @DateTime 2022-12-01 13:17
 * @Desc
 */
public class ClassPathResource implements Resource {

    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (inputStream == null) {
            throw  new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return inputStream;
    }
}
