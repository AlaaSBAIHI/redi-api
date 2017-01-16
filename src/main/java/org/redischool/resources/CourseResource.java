package org.redischool.resources;

import org.redischool.models.Course;
import org.redischool.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by ReDI on 1/16/2017.
 */
@Component
@Path("course")
public class CourseResource {
    private final CourseService courseService;

    @Autowired
    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }


    @POST
    private Response create() {
        String couId = courseService.generateId();
        return Response.created(URI.create("course/" + couId)).entity(couId).build();
    }

    @Path("id")
    @PUT
    public Response saveCourse(@Param("couId") String couId, Course course) {
        return Response.ok().entity(courseService.getCourse(couId)).build();
    }

    @Path("id")
    @GET
    public Response getCourse(@Param("couId") String couId) {
        return Response.ok().entity(courseService.getCourse(couId)).build();
    }

}
