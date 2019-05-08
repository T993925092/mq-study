package com.txl.mqstudy.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author tangxl
 * @CreateTime 2019/4/28 17:42
 */
@Component
public class KafkaConsumerListener {

//    @KafkaListener(topics = {"kafkastudy"})
    public void listen(ConsumerRecord consumerRecord){
        Optional kafkamesss=Optional.ofNullable(consumerRecord.value());
        if(kafkamesss.isPresent()){
            System.out.println("接收到生产者生产的消息,"+consumerRecord.value());
        }
    }
}
