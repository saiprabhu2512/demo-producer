package com.example.producer.service;

import com.example.producer.proto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String KAFKA_TOPIC = "myTopic";
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void processEmployeeJson(Employee employee){
        try{
            kafkaTemplate.send(KAFKA_TOPIC, employee);
    }catch(Exception e){
            e.printStackTrace();
        }
    }
}
