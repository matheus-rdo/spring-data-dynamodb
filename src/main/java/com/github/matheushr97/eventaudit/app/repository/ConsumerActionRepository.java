package com.github.matheushr97.eventaudit.app.repository;

import com.github.matheushr97.eventaudit.config.ApplicationConfig;
import com.github.matheushr97.eventaudit.domain.model.ConsumerActionLog;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ConsumerActionRepository {

    private DynamoDbEnhancedClient enhancedClient;
    private DynamoDbTable<ConsumerActionLog> dynamoTable;

    public ConsumerActionRepository(DynamoDbEnhancedClient enhancedClient, ApplicationConfig.DynamoSettings settings) {
        this.enhancedClient = enhancedClient;
        this.dynamoTable = enhancedClient.table(settings.getTableName(), TableSchema.fromBean(ConsumerActionLog.class));

    }

    public List<ConsumerActionLog> findByConsumerID(String consumerID) {
        Key key = Key.builder()
                .partitionValue(consumerID)
                .build();


        var enhancedQuery = QueryEnhancedRequest.builder()
                .queryConditional(QueryConditional.keyEqualTo(key))
                .scanIndexForward(false)
                .limit(10)
                .build();

        return dynamoTable.query(enhancedQuery).items().stream().collect(Collectors.toList());
    }

    public void save(ConsumerActionLog consumerAction) {
        dynamoTable.putItem(consumerAction);
    }


}
