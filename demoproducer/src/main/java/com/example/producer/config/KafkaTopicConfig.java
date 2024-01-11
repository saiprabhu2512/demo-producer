//package com.example.producer.config;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaTopicConfig {
//
//    @Value(value = "${spring.kafka.producer.bootstrap-servers}")
//    private  String bootStrapserver;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin(){
//
//        Map<String, Object> props = new HashMap<>();
//        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapserver );
//        return new KafkaAdmin(props);
//    }
//
//    @Bean
//    public NewTopic newTopic(){
//        return new NewTopic("demo", 1, (short)2);
//    }
//
//
//}
