package com.loki.aws.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    public static final String SERVICE_END_POINT = "dynamodb.us-east-1.amazonaws.com";
    public static final String SIGNING_REGION = "us-east-1";
    public static final String ACCESS_KEY = "AKIARYPGQ4VLBM52S33E";
    public static final String SECRET_KEY = "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";

    @Bean
    public DynamoDBMapper mapper(){
        return new DynamoDBMapper(amazonDynamoDBConfig());
    }

    private AmazonDynamoDB amazonDynamoDBConfig() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_END_POINT, SIGNING_REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))).build();
    }
}
