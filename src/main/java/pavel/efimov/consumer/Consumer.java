package pavel.efimov.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    private final MessageService messageService;

    public Consumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @JmsListener(destination = "sender.queue")
    public void receive(String message) {
        log.info("received message='{}'", message);
        Message newMsg = new Message();
        newMsg.setMessage(message);
        messageService.save(newMsg);
    }
}
