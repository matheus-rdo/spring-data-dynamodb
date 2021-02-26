package com.github.matheushr97.eventaudit.app.repository;

import com.github.matheushr97.eventaudit.config.ApplicationConfig;
import com.github.matheushr97.eventaudit.domain.model.ConsumerActionLog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
@AllArgsConstructor
public class ConsumerActionRepository {

    private DynamoDbEnhancedClient enhancedClient;
    private ApplicationConfig.DynamoSettings settings;

    public void save(ConsumerActionLog consumerAction) {
        var mappedTable = enhancedClient.table(settings.getTableName(), TableSchema.fromBean(ConsumerActionLog.class));
        mappedTable.putItem(consumerAction);
    }


}
