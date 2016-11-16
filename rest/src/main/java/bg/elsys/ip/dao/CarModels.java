package bg.elsys.ip.dao;

import java.util.HashMap;
import java.util.Map;

import bg.elsys.ip.rest.Car;

public enum CarModels {

instance;
	
	private Map<String, Car> contentProvider = new HashMap<>();
	
	private CarModels() {
		
		Car car = new Car("1", "AUDI");
		car.setModel("A5");
		contentProvider.put("1",  car);
		
		car = new Car("2", "BMW");
		car.setModel("X5");
		contentProvider.put("2", car);
		
		car = new Car("3", "Toyota");
		car.setModel("Rav4");
		contentProvider.put("3", car);
	}
	
	public Map<String, Car> getModel() {
		return contentProvider;
	}
	
}
