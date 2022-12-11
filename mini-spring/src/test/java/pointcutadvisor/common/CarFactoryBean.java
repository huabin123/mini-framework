package pointcutadvisor.common;

import pointcutadvisor.beans.factory.FactoryBean;
import pointcutadvisor.bean.Car;

/**
 * @Author huabin
 * @DateTime 2022-12-07 22:05
 * @Desc
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(brand);
        return car;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
