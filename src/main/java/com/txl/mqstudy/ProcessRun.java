package com.txl.mqstudy;

import com.txl.mqstudy.thread.ActiveMqProducerThread;
import com.txl.mqstudy.thread.RabbitMQProduceThread;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author tangxl
 * @CreateTime 2019/4/28 14:55
 */
@Component
public class ProcessRun implements ApplicationRunner {
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//    @Autowired
//    private ConsumerFactory consumerFactory;
//    @Autowired
//    private ProducerFactory producerFactory;
//    @Autowired
//    private JmsTemplate jmsTemplate;
//    @Autowired
//    private Topic acvtiveTopic;
//    @Autowired
//    private Queue activeQueue;
    @Autowired
    private AmqpTemplate rabbitTemplate;




    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Thread produceThread=new Thread(new kafkaProducerThread(producerFactory.createProducer()));
//        produceThread.setName("produceThread");
//        produceThread.start();
//        Thread consumer=new Thread(new KafkaConsumerThread(consumerFactory.createConsumer()));
//        consumer.setName("consumerThread");
//        consumer.start();
//        Thread activeProduce=new Thread(new ActiveMqProducerThread(acvtiveTopic,activeQueue,jmsTemplate));
//        activeProduce.setName("activeMQProduceThread");
//        activeProduce.start();
        //rabbit
        Thread thread=new Thread(new RabbitMQProduceThread(rabbitTemplate));
        thread.setName("rabbitProducer");
        thread.start();


    }
}
