package com.txl.mqstudy.thread;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author tangxl
 * @CreateTime 2019/4/29 10:05
 */
public class ActiveMqProducerThread implements Runnable{
    private Topic topic;
    private Queue queue;
    private JmsTemplate jmsTemplate;
    public ActiveMqProducerThread(Topic acvtiveTopic, Queue activeQueue, JmsTemplate jmsTemplate) {
        this.topic=acvtiveTopic;
        this.queue=activeQueue;
        this.jmsTemplate=jmsTemplate;
    }

    @Override
    public void run() {
        int i=1;
        while (true) {
            try {
                jmsTemplate.convertAndSend(topic, Thread.currentThread().getName()+":你好呀,topic:"+topic.getTopicName()+"这是第"+i+"次");
                jmsTemplate.convertAndSend(queue,Thread.currentThread().getName()+":你好呀,quene:"+queue.getQueueName()+"这是第"+i+"次");
                i++;
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
