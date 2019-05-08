//package com.txl.mqstudy.listener;
//
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Author tangxl
// * @CreateTime 2019/4/29 14:40
// */
//@Component
//public class ActiveMQConsumerListener {
//    @JmsListener(destination = "activequene",containerFactory = "jmsListenerContainerQueue")
//    public void reciveMess(String text){
//        System.out.println("消费监听器收到消息:"+text);
//    }
//
//    @JmsListener(destination = "activemqstudy",containerFactory = "jmsListenerContainerTopic")
//    public  void topicReceive(String mess){
//        System.out.println("topic监听器收到消息:"+mess);
//    }
//}
