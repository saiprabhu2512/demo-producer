package com.example.producer.controller;

import com.example.producer.model.Employee;
import com.example.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String KAFKA_TOPIC = "myTopic";

    @PostMapping("/produce")
    public String produceEmployee(@RequestBody Employee employee){

        com.example.producer.proto.Employee protoEmployee = com.example.producer.proto.Employee.newBuilder()
                .setName(employee.getName())
                .setSalary(employee.getSalary())
                .setDesignation(employee.getDesignation())
                .setGender(employee.getGender())
                .setOperation("Insert")
                .build();

        kafkaProducerService.processEmployeeJson(protoEmployee);

        System.out.println("Producing employee " + protoEmployee);

        return "Employee Produced Successfully";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){

        com.example.producer.proto.Employee deleteMessage = com.example.producer.proto.Employee.newBuilder()
                .setId(id)
                .setOperation("Delete")
                .build();

        kafkaTemplate.send(KAFKA_TOPIC, String.valueOf(id), deleteMessage);

        System.out.println("Employee deletion request sent with id " + id);

        return ResponseEntity.ok("Employee with id " + id + " deletion request sent successfully");
    }


}
