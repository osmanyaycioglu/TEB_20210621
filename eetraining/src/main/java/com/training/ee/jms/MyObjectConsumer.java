package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "JMSObjectQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Queue")
}, mappedName = "JMSObjectQueue")
public class MyObjectConsumer implements MessageListener {

    @Override
    public void onMessage(final Message message) {

        if (message instanceof ObjectMessage) {
            ObjectMessage tm = (ObjectMessage) message;
            try {
                System.out.println("MyObjectConsumer Received : " + tm.getObject());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
        System.out.println("MyObjectConsumer : " + message);
    }

}
