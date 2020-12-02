package com.example.subscriber;

import com.example.dto.Employee;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

@Component
@RequiredArgsConstructor
public class JMSReceiver implements MessageListener {
    @SneakyThrows
    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        Serializable dto = ((ObjectMessage)message).getObject();
        Employee employee = (Employee)dto;
        System.out.println(message);
        System.out.println(employee);
    }
}