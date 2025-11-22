package org.unipds;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;

@Path("/time-api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeApiResource {

    @GET
    public String hello() throws InterruptedException {
        //Thread.sleep(5000); condição para acionar circuit breaker
        return LocalDateTime.now() +"\n";
    }
}
