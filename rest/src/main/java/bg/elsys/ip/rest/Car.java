package bg.elsys.ip.rest;

public class Car {
	int id;
	String name;
	String model;
	
	public Car() {
	
	}

	public Car(int id, String name, String model) {
		super();
		this.id = id;
		this.name = name;
		this.model= model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

}