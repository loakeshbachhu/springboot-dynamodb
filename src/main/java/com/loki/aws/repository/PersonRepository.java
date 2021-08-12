package com.loki.aws.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.loki.aws.config.DynamoDBConfig;
import com.loki.aws.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public Person addPerson(Person person){
        mapper.save(person);
        return person;
    }

    public Person findPersonByPersonId(String personId){
      return mapper.load(Person.class,personId);

    }
}
