package com.thoughtworks.gaia.exam.endpoint;

import com.thoughtworks.gaia.exam.entity.Exam;
import com.thoughtworks.gaia.exam.service.ExamService;
import com.thoughtworks.gaia.product.entity.Product;
import com.thoughtworks.gaia.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by wyli on 16/11/24.
 */
@Component
@Path("exams")
@Api(value = "exams", description = "Access to exam resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExamEndPoint {
    @Autowired
    private ExamService examService;
    @Autowired
    private ProductService productService;

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

    @Path("/{templateId}")
    @ApiOperation(value = "Post new exam", response = Exam.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Post new exam successfully"),
            @ApiResponse(code = 400, message = "Post new exam failed")
    })
    @POST
    public Response postExam(@PathParam("templateId") Long templateId) {
        Exam exam = examService.createExam(templateId);
        return Response.ok().entity(exam).build();
    }
}
