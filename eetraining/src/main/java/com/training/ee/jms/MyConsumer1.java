package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Queue")
}, mappedName = "JMSQueue")
public class MyConsumer1 implements MessageListener {

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
                System.out.println("MyConsumer1 Received : " + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
        System.out.println("MyConsumer1 : " + message);
    }

}
