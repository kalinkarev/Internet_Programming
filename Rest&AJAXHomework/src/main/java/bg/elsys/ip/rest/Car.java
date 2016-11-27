package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Car {

	@ApiModelProperty(required = true)
	private String name;
	private String model;
	private int year;
	private String produced_where;
	private String fuel;
	
	public Car() {
	
	}
	
	public Car(String name, String model, int year, String produced_where, String fuel) {
		super();
		this.name = name;
		this.model = model;
		this.year = year;
		this.produced_where = produced_where;
		this.fuel = fuel;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getProcudedWhere() {
		return produced_where;
	}
	
	public void setProducedWhere(String produced_where) {
		this.produced_where = produced_where;
	}
	
	public String getFuel() {
		return fuel;
	}
	
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
}


/*	
	@ApiModelProperty(required = true)
	private int id;
	private String name;

	public Car() {
	}

	public Car(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	
}
*/