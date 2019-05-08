package com.txl.mqstudy.thread;

import org.springframework.amqp.core.AmqpTemplate;

/**
 * @Author tangxl
 * @CreateTime 2019/5/8 10:31
 */
public class RabbitMQProduceThread implements Runnable{
    private AmqpTemplate rabbitTemplate;
    public RabbitMQProduceThread(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate=rabbitTemplate;
    }

    @Override
    public void run() {
        while (true) {
            rabbitTemplate.convertAndSend("direcExchange", "api.notify", "你好呀,直接路由器,rootingkey是api.notify");
            System.out.println("已经向direcExchange发送一条消息");
            rabbitTemplate.convertAndSend("coreExchange","api.core.uuuu","你好啊,topic路由器,rootingkey是api.core.uuu");
            System.out.println("已经向coreExchange发送一条消息");
            rabbitTemplate.convertAndSend("coreExchange","api.core.uuuu.hhhh","你好啊,topic路由器,rootingkey是api.core.uuuu.hhhh");
            System.out.println("已经向coreExchange发送一条消息");
            rabbitTemplate.convertAndSend("paymentExchange","api.payment.hhah.hahh","你好啊,topic路由器,rootingkey是api.payment.hhah.hahh");
            System.out.println("已经向paymentExchange发送一条消息");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
