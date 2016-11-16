package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.IIOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/cars")
public class CarsResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Car> getCarsBrowser() {
		List<Car> cars = new ArrayList<Car>();
		cars.addAll(bg.elsys.ip.dao.CarModels.instance.getModel().values());
		return cars;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Car> getCars() {
		List<Car> cars = new ArrayList<Car>();
		cars.addAll(bg.elsys.ip.dao.CarModels.instance.getModel().values());
		return cars;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = bg.elsys.ip.dao.CarModels.instance.getModel().size();
		return String.valueOf(count);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public <HttpServletResponse> void newCar(@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("model") String model,
			@Context HttpServletResponse servletResponse) throws IIOException {
		Car car = new Car(id, name);
		bg.elsys.ip.dao.CarModels.instance.getModel().put(id, car);
		
//		servletResponse.sendRedirect("../index.html");
	}
	
	@Path("{todos}")
	public CarResource getCar(@PathParam("car") String id) {
		return new CarResource(uriInfo, request, id);
	}
}
