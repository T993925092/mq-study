package com.txl.mqstudy.thread;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Random;

/**
 * @Author tangxl
 * @CreateTime 2019/4/28 11:23
 */
public class kafkaProducerThread implements Runnable{
    private KafkaTemplate kafkaTemplate;
    private Producer producer;

    public kafkaProducerThread(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate=kafkaTemplate;
    }

    public kafkaProducerThread(Producer producer) {
        this.producer=producer;
    }

    @Override
    public void run() {
        int i=1;
        while (true){
            kafkaTemplate.send("kafkastudy","你好呀,随机数"+ new Random().nextInt(10000000)+",这是第"+i+"条");
            i++;
            System.out.println(Thread.currentThread().getName()+"生产者生产一条数据完毕"+"这是第"+(i-1)+"条");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
