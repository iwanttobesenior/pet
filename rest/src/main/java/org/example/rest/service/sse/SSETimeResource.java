package org.example.rest.service.sse;

import javax.annotation.PreDestroy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

@Path(value = "/time")
public class SSETimeResource {

    private final AtomicBoolean stopFlag = new AtomicBoolean(false);

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void currentTime(@Context final SseEventSink eventSink, @Context final Sse event) {
        new Thread(() ->
        {

            while (!stopFlag.get()) {
                OutboundSseEvent sseEvent = event
                        .newEventBuilder()
//                        .name("current-time")
                        .data(String.class, LocalDateTime.now().toString())
                        .build();

                eventSink.send(sseEvent);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            eventSink.close();

        }).start();
    }

    @PreDestroy
    private void preDestroy() {
        stopFlag.set(true);
    }
}
