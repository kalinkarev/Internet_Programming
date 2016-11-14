package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cars")
public class CarModels {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(1, "AUDI", "A5"));
		cars.add(new Car(2, "BMW", "X5"));
		return Response.ok(cars).build();
	}
}