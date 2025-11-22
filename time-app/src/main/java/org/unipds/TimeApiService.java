package org.unipds;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.LocalDateTime;

@RegisterRestClient(baseUri = "http://localhost:8081/time-api")
public interface TimeApiService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timeout(3000L)
    @Fallback(
            fallbackMethod = "getTimeFallback"
    )
    @CircuitBreaker(
            requestVolumeThreshold = 4, //quantidade de requisições minimas para analisar se existe um problema
            failureRatio = 0.5, // quantidade de requisições com problemas necessário para abrir o circuito (50%)
            delay = 5000L, // tempo necessário para alterar estado para half open
            successThreshold = 2 // quantidade de requisições com sucesso para verificar se deve fechar o circuito

    )
    public String getTime();

    default String getTimeFallback(){
     return "Fallback " + LocalDateTime.now();
    }
}
