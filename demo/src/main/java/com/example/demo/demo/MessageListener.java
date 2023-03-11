package com.example.demo.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;

@Component
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @JmsListener(destination = "queue-1")
    public void sampleJmsListenerMethod(TextMessage message) throws JMSException {
        logger.info("JMS listener received text message: {}", message.getText());
    }
}
