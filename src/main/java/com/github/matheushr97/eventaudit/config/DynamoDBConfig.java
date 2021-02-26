package com.github.matheushr97.eventaudit.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
@AllArgsConstructor
public class DynamoDBConfig {

    private AwsConfig awsConfig;

    @Bean
    public DynamoDbClient dynamoClient() {
        var builder = DynamoDbClient.builder()
                .region(Region.of(awsConfig.getRegion()));

        awsConfig.getEndpoint().
                ifPresent(endpoint -> builder.endpointOverride(endpoint));

        return builder.build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoEnhancedClient(DynamoDbClient client) {
        return DynamoDbEnhancedClient
                .builder()
                .dynamoDbClient(client)
                .build();
    }

}
