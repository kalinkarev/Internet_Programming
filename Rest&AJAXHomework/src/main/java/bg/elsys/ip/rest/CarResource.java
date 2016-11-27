package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/cars")
@Api(value="Api for quesrying cars")
public class CarResource {

//	@Path("/carsfilterbyName")
	@GET
	@ApiOperation(value = "get all cars", response = Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars(@QueryParam("page") int page, @QueryParam("perPage") int perPage,
			@QueryParam("with-name") String withName) {
		
		CarService carService = CarService.getInstance();
		PagedResponseCar carsResponse = carService.getCarsInPagesFiltered(page, perPage, withName);
		return Response.ok(carsResponse).build();
	}
	
	@Path("/names")
	@GET
	@ApiOperation("get all distinct car names")
	@Produces(MediaType .APPLICATION_JSON)
	public List<String> getAllDistinctCarName() {
		return CarService.getInstance().getAllDistinctCarNames();
	}
	
	@Path("/carsfilterbyModel")
	@GET
	@ApiOperation(value = "get all cars", response = Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarsByModel(@QueryParam("page") int page, @QueryParam("perPage") int perPage,
			@QueryParam("with-model") String withModel) {

		CarService carService = CarService.getInstance();
		PagedResponseCar carsResponse = carService.getCarsInPagesFilteredByModel(page, perPage, withModel);
		return Response.ok(carsResponse).build();

	}
	
	@Path("/models")
	@GET
	@ApiOperation("get all distinct car models")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllDistinctCarModels() {
		return CarService.getInstance().getAllDistinctCarModels();
	}

	@Path("/carsfilterbyYear")
	@GET
	@ApiOperation(value = "get all cars", response = Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarsByModel(@QueryParam("page") int page, @QueryParam("perPage") int perPage,
			@QueryParam("with-year") Integer withYear) {

		CarService carService = CarService.getInstance();
		PagedResponseCar carsResponse = carService.getCarsInPagesFilteredByYear(page, perPage, withYear);
		return Response.ok(carsResponse).build();

	}
	
	@Path("/years")
	@GET
	@ApiOperation("get all distinct car year of producement")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Integer> getAllDistinctCarYears() {
		return CarService.getInstance().getAllDistinctCarYears();
	}
	
	@POST
	@ApiOperation(value = "create new car")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car) {
		CarService.getInstance().addCar(car);

		return Response.ok(car).status(Status.CREATED).build();
	}
	
	@Path("/carsfilterbyCountry")
	@GET
	@ApiOperation(value = "get all cars", response = Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarsByCountry(@QueryParam("page") int page, @QueryParam("perPage") int perPage,
			@QueryParam("with-country") String withCountry) {

		CarService carService = CarService.getInstance();
		PagedResponseCar carsResponse = carService.getCarsInPagesFilteredByCountry(page, perPage, withCountry);
		return Response.ok(carsResponse).build();

	}
	
	@Path("/country")
	@GET
	@ApiOperation("get all distinct car country of producing")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllDistinctCarCountrys() {
		return CarService.getInstance().getAllDistinctCarCountrys();
	}
	
	@Path("/carsfilterbyfuel")
	@GET
	@ApiOperation(value = "get all cars", response = Car.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCarsByFuel(@QueryParam("page") int page, @QueryParam("perPage") int perPage,
			@QueryParam("with-fuel") String withFuel) {

		CarService carService = CarService.getInstance();
		PagedResponseCar carsResponse = carService.getCarsInPagesFilteredByFuel(page, perPage, withFuel);
		return Response.ok(carsResponse).build();

	}
	
	@Path("/fuel")
	@GET
	@ApiOperation("get all distinct car with fuel")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllDistinctCarFuels() {
		return CarService.getInstance().getAllDistinctCarFuels();
	}
	
	
	
	
}