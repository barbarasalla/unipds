package org.unipds;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    TimeApiService timeApiService;

    @Override
    public HealthCheckResponse call() {
        if (timeApiService.getTime().contains("Fallback")){
            return HealthCheckResponse.down("I'm not read");
        } else {
            return HealthCheckResponse.up("I'm read");
        }
    }
}
