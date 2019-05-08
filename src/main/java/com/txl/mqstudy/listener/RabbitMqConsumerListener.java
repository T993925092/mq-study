package com.txl.mqstudy.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author tangxl
 * @CreateTime 2019/5/8 10:43
 */
@Component
public class RabbitMqConsumerListener {
//    @RabbitHandler
//    @RabbitListener(queues = "notify.payment")
//    public void receiveDirecExchange(String msg){
//        System.out.println("收到消息"+msg);
//    }

    @RabbitHandler
    @RabbitListener(queues = {"api.core","api.payment"})
    public  void receiverTopicExchange(String msg){
        System.out.println("收到消息"+msg);

    }
}
