package com.training.ee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.training.ee.jpa.Employee;

@Path("/jms")
public class JMSRest {

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "java:/jms/queue/JMSQueue")
    private Queue      queue;

    @Resource(lookup = "java:/jms/queue/JMSObjectQueue")
    private Queue      objectQueue;

    @Resource(lookup = "java:/jms/topic/JMSTopic")
    private Topic      topic;

    @Path("/send/queue")
    @Produces("text/plain")
    @GET
    public String sendToQueue(@QueryParam("msg") final String msg) {
        this.jmsContext.createProducer()
                       .send(this.queue,
                             msg);
        return "OK";
    }

    @Path("/send/topic")
    @Produces("text/plain")
    @GET
    public String sendToTopic(@QueryParam("msg") final String msg) {
        this.jmsContext.createProducer()
                       .send(this.topic,
                             msg);
        return "OK";
    }

    @Path("/send/employee/queue")
    @Produces("text/plain")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON
    })
    public String sendToObjQueue(final Employee emp) {
        this.jmsContext.createProducer()
                       .send(this.objectQueue,
                             emp);
        return "OK";
    }

    @Path("/send/text/queue")
    @Produces("text/plain")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON
    })
    public String sendToTextQueue(final Employee emp) {
        Jsonb jsonb = JsonbBuilder.create();
        String jsonLoc = jsonb.toJson(emp);
        this.jmsContext.createProducer()
                       .send(this.queue,
                             jsonLoc);
        return "OK";
    }


}
