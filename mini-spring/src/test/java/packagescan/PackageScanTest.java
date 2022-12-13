package packagescan;

import org.junit.Test;
import packagescan.bean.Car;
import packagescan.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @Author huabin
 * @DateTime 2022-12-13 10:04
 * @Desc
 */
public class PackageScanTest {

    @Test
    public void testPackageScan() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:package-scan.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car).isNotNull();
    }

}
