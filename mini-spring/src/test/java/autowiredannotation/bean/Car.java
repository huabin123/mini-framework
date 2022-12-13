package autowiredannotation.bean;

import autowiredannotation.beans.factory.annotation.Value;
import autowiredannotation.stereotype.Component;

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
