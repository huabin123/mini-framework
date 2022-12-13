package circularreferencewithproxybean.bean;

import circularreferencewithproxybean.beans.factory.DisposableBean;
import circularreferencewithproxybean.beans.factory.InitializingBean;
import circularreferencewithproxybean.beans.factory.annotation.Autowired;
import circularreferencewithproxybean.stereotype.Component;

/**
 * @author derekyi
 * @date 2020/11/24
 */
@Component
public class Person implements InitializingBean, DisposableBean {

	private String name;

	private int age;

	@Autowired
	private Car car;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void customInitMethod(){
		System.out.println("I was born in the method named customInitMethod");
	}

	public void customDestroyMethod() {
		System.out.println("I died in the method named customDestroyMethod");
	}

	@Override
	public void afterPropertiesSet() {
		System.out.println("I was born in the method named afterPropertiesSet");
	}

	@Override
	public void destroy() {
		System.out.println("I died in the method named destroy");
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", car=" + car +
				'}';
	}
}
