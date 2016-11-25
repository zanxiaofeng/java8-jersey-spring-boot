package com.thoughtworks.gaia.quizrepository.endpoint;

import com.thoughtworks.gaia.quizrepository.entity.QuizRepository;
import com.thoughtworks.gaia.quizrepository.service.QuizRepositoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("quizrepositories")
@Api(value = "quizrepository", description = "Access to quiz repositories related resources")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuizRepositoryEndPoint {
    @Context
    UriInfo uriInfo;

    @Autowired
    private QuizRepositoryService qrService;

    @ApiOperation(value = "Get all quiz repositories", response = QuizRepository.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get quiz repository successfully"),
            @ApiResponse(code = 404, message = "Cannot get quiz respository")
    })
    @GET
    public Response getAllQuizRepositories() {
        List<QuizRepository> repositories = qrService.getAllQuizRepositories();

        Link[] links = repositories.stream().map(
                repository -> Link.fromUri(uriInfo.getAbsolutePathBuilder().path(repository.getId().toString()).build()).build()
            ).collect(Collectors.toList()).toArray(new Link[repositories.size()]);

        return Response.ok().links(links).build();
    }

    /*
    @Path("/{product_id}")
    @ApiOperation(value = "Get product by id", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get product successfully"),
            @ApiResponse(code = 404, message = "No product matches given id")
    })
    @GET
    public Response getProduct(@PathParam("product_id") Long productId) {
        Product product = productService.getProduct(productId);
        return Response.ok().entity(product).build();
    }
    */
}
