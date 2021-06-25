package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@JMSDestinationDefinitions({
                             @JMSDestinationDefinition(destinationName = "JMSQueue",
                                                       name = "java:/jms/queue/JMSQueue",
                                                       interfaceName = "javax.jms.Queue"),
                             @JMSDestinationDefinition(destinationName = "JMSTopic",
                                                       name = "java:/jms/topic/JMSTopic",
                                                       interfaceName = "javax.jms.Topic"),
                             @JMSDestinationDefinition(destinationName = "JMSObjectQueue",
                                                       name = "java:/jms/queue/JMSObjectQueue",
                                                       interfaceName = "javax.jms.Queue")

})
@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Queue")
}, mappedName = "JMSQueue")
public class MyQueueListener implements MessageListener {

    public MyQueueListener() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
                System.out.println("MyQueueListener Received : " + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
        System.out.println("MyQueueListener : " + message);
    }

}
