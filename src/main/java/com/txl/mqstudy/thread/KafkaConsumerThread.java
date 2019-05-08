package com.txl.mqstudy.thread;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * @Author tangxl
 * @CreateTime 2019/4/28 11:24
 */
public class KafkaConsumerThread implements Runnable{
    private Consumer kafkaConsumer;


    public KafkaConsumerThread(Consumer consumer) {
      this.kafkaConsumer=consumer;
    }

    @Override
    public void run() {
        //订阅一个或者多个topic
        kafkaConsumer.subscribe(Arrays.asList("kafkastudy"));
        kafkaConsumer.commitSync();
        while (true){
            ConsumerRecords records=kafkaConsumer.poll(Duration.ofSeconds(20));
            Iterator<ConsumerRecord> iterator=records.iterator();
            while (iterator.hasNext()){
                ConsumerRecord consumerRecord=iterator.next();
                System.out.println(Thread.currentThread().getName()+"消费线程消费到消息:offset="+consumerRecord.offset()+",partition="+consumerRecord.partition()+",value="+consumerRecord.value());
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
