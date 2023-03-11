package com.example.demo.demo;

import org.apache.activemq.artemis.junit.EmbeddedActiveMQResource;
import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

import org.apache.activemq.artemis.api.core.Message;
import org.apache.activemq.artemis.api.core.client.ClientMessage;
import org.apache.activemq.artemis.core.client.impl.ClientMessageImpl;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;



import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.TextMessage;
@ContextConfiguration(classes = { JmsConfig.class, MessageSender.class })
public class EmbeddedActiveMqTest {
    
    @Autowired
    private MessageSender messageSender;

    @ClassRule
    public static EmbeddedActiveMQResource embeddedBroker = new EmbeddedActiveMQResource();

    @Test
    public void whenSendingMessage_thenCorrectQueueAndMessageText() throws JMSException {
        String queueName = "danielsqueue";
        String messageText = "Test message";
    
       // messageSender.sendTextMessage(queueName, messageText);
    
      //  assertEquals(1, embeddedBroker.getMessageCount(queueName));
        embeddedBroker.createQueue(queueName);
        
        embeddedBroker.sendMessage(embeddedBroker.getVmURL(), embeddedBroker.createMessage());
        System.out.println("Count" + embeddedBroker.getMessageCount(queueName));
    }

    @Test
    public void test() {
    }

    // ...
}

