package com.thoughtworks.gaia.user.endpoint;

import com.thoughtworks.gaia.user.entity.User;
import com.thoughtworks.gaia.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("users")
@Api(value = "users", description = "Access to user resource")
@Produces(MediaType.APPLICATION_JSON)
public class UserEndPoint {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Create user by id and password", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create user successfully"),
            @ApiResponse(code = 404, message = "The id is already exists")
    })
    @POST
    public Response createUser(@FormParam("id") String userId, @FormParam("password") String password) {
        User user = userService.createUser(userId, password);
        return Response.ok().entity(user).build();
    }

    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "update user by id", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Update user successfully"),
            @ApiResponse(code = 404, message = "No product matches given id")
    })
    @PUT
    public Response updateUser(@PathParam("id") Long id, @RequestBody User user) {
        user.setId(id);
        User user1 = userService.updateUser(user);
        return Response.ok().entity(user1).build();
    }
}
