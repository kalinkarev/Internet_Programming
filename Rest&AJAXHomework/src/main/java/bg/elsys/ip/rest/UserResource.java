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

@Path("/users")
@Api(value="Api for quesrying users")
public class UserResource {

	@GET
	@ApiOperation(value = "get all users", response = User.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@QueryParam("page") int page, @QueryParam("perPage") int perPage,
			@QueryParam("with-name") String withName) {
		
		UserService userService = UserService.getInstance();
		PagedResponse usersResponse = userService.getUsersInPagesFiltered(page, perPage, withName);
		return Response.ok(usersResponse).build();
	}
	
	@Path("/names")
	@GET
	@ApiOperation("get all distinct user names")
	@Produces(MediaType .APPLICATION_JSON)
	public List<String> getAllDistinctUserName() {
		return UserService.getInstance().getAllDistinctUserNames();
	}

	@POST
	@ApiOperation(value = "create new user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		UserService.getInstance().addUser(user);

		return Response.ok(user).status(Status.CREATED).build();
	}
}