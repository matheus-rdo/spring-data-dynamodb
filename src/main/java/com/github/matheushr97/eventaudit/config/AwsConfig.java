package com.github.matheushr97.eventaudit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.Optional;

@Configuration
@Getter
@Setter
public class AwsConfig {

    @Value("${AWS_ENDPOINT:#{null}}")
    private Optional<URI> endpoint;

    @Value("${AWS_REGION:us-east-1}")
    private String region;


}
