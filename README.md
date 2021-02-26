# Spring DynamoDB

## Stack

- Java 11
- Spring Boot
- DynamoDB (AWS V2)

## Local deveopment

### Requirements

- [Localstack](https://github.com/localstack/localstack)
- [awslocal (CLI)](https://github.com/localstack/awscli-local)

### Create resources

Start localstack
`docker-compose up -d`

Create DynamoDB table

```shell script

awslocal dynamodb create-table \
    --table-name eventaudit \
    --attribute-definitions AttributeName=consumerID,AttributeType=S AttributeName=actionDate,AttributeType=S \
    --key-schema AttributeName=consumerID,KeyType=HASH AttributeName=actionDate,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST

```

## References
- https://serhatcan.medium.com/how-to-migrate-from-dynamodb-java-sdk-v1-to-v2-2e3660729e05
- https://github.com/awsdocs/aws-doc-sdk-examples/tree/master/javav2/example_code/dynamodb 
- https://github.com/aws/aws-sdk-java-v2/tree/master/services-custom/dynamodb-enhanced
- https://github.com/aws/aws-sdk-java-v2/