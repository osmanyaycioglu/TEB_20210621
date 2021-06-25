package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSTopic"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Topic")
}, mappedName = "JMSTopic")
public class MyTopicConsumer2 implements MessageListener {

    public MyTopicConsumer2() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
                System.out.println("MyTopicConsumer2 Received : " + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
        System.out.println("MyTopicConsumer2 : " + message);
    }

}
