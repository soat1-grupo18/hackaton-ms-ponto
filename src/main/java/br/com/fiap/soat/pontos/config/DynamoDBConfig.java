package br.com.fiap.soat.pontos.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DynamoDBConfig {
    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.dynamodb.endpoint}")
    private String dynamoDbEndpoint;

    @Value("${aws.dynamodb.accessKey}")
    private String awsAccessKeyId;

    @Value("${aws.dynamodb.secretKey}")
    private String awsSecretAccessKey;

    @Bean("amazonDynamoDB")
    @Profile("aws")
    public AmazonDynamoDB productionAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
            .withRegion(awsRegion)
            .build();
    }

    @Bean("amazonDynamoDB")
    @Profile("!aws")
    public AmazonDynamoDB localAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey)))
            .withEndpointConfiguration(new AmazonDynamoDBClientBuilder.EndpointConfiguration(dynamoDbEndpoint, awsRegion))
            .build();
    }
}
