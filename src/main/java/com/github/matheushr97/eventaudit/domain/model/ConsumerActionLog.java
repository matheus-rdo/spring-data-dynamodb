package com.github.matheushr97.eventaudit.domain.model;

import lombok.Builder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;

@DynamoDbBean
public class ConsumerActionLog {

    private String consumerID;
    private Instant actionDate;

    private String action;
    private String detail;

    @DynamoDbPartitionKey
    public String getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(String consumerID) {
        this.consumerID = consumerID;
    }

    public ConsumerActionLog withConsumerID(String consumerID) {
        setConsumerID(consumerID);
        return this;
    }

    @DynamoDbSortKey
    public Instant getActionDate() {
        return actionDate;
    }

    public void setActionDate(Instant actionDate) {
        this.actionDate = actionDate;
    }

    public ConsumerActionLog withActionDate(Instant actionDate) {
        setActionDate(actionDate);
        return this;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ConsumerActionLog withAction(String action) {
        setAction(action);
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ConsumerActionLog withDetail(String detail) {
        setDetail(detail);
        return this;
    }
}
