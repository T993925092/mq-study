package com.txl.mqstudy.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author tangxl
 * @CreateTime 2019/5/8 10:10
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue coreQueue() {
        return new Queue("api.core");
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue("api.payment");
    }

    @Bean
    public TopicExchange coreExchange() {
        return new TopicExchange("coreExchange");
    }

    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange("paymentExchange");
    }

    @Bean
    public Binding bindingCoreExchange(Queue coreQueue, TopicExchange coreExchange) {
        return BindingBuilder.bind(coreQueue).to(coreExchange).with("api.core.*");
    }

    @Bean
    public Binding bindingPaymentExchange(Queue paymentQueue, TopicExchange paymentExchange) {
        return BindingBuilder.bind(paymentQueue).to(paymentExchange).with("api.payment.#");
    }

    @Bean
    public Queue paymentNotifyQueue() {
        return new Queue("notify.payment");
    }

    @Bean
    public DirectExchange directExchange(){
        return  new DirectExchange("direcExchange");
    }

    @Bean
    public Binding bindingDirecExchange(Queue paymentNotifyQueue,DirectExchange directExchange){
        return BindingBuilder.bind(paymentNotifyQueue).to(directExchange).with("api.notify");
    }
}
