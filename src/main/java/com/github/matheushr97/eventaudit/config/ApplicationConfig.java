package com.github.matheushr97.eventaudit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {

    @Configuration
    @Getter
    @Setter
    public class DynamoSettings {

        @Value("${APP_DYNAMODB_TABLE}")
        private String tableName;
    }


}
