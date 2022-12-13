package populateproxybeanwithpropertyvalues.bean;

import populateproxybeanwithpropertyvalues.beans.factory.annotation.Value;
import populateproxybeanwithpropertyvalues.stereotype.Component;

/**
 * @author derekyi
 * @date 2020/11/24
 */

@Component
public class Car {

	@Value("${brand}")
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car{" +
				"brand='" + brand + '\'' +
				'}';
	}
}
