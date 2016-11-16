package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class CarResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	
	public CarResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Car getCar() {
		Car car = bg.elsys.ip.dao.CarModels.instance.getModel().get(id);
		if (car == null) {
			throw new RuntimeException("Getting: Car with " + id + " Not found");
		}
		return car;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Car getCarHTML() {
		Car car = bg.elsys.ip.dao.CarModels.instance.getModel().get(id);
		if (car == null)
			throw new RuntimeException("Getting car with " + id + " Not found");
		return car;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putCar(JAXBElement<Car> car) {
		Car c = car.getValue();
		return putAndGetResponse(c);
	}
	
	@DELETE
	public void deleteCar() {
		Car c = bg.elsys.ip.dao.CarModels.instance.getModel().remove(id);
		if (c == null)
			throw new RuntimeException("Deleting: Car with " + id + " Not found for delete");
	}
	
	private Response putAndGetResponse(Car car) {
		Response res;
		if (bg.elsys.ip.dao.CarModels.instance.getModel().containsKey(car.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		bg.elsys.ip.dao.CarModels.instance.getModel().put(car.getId(), car);
		return res;
	}
	
}
