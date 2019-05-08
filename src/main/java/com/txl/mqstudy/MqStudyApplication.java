package com.txl.mqstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableJms
@EnableKafka
public class MqStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqStudyApplication.class, args);
    }

}
