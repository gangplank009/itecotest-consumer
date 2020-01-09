package pavel.efimov.consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
public class MessageServiceImplTest {

    @MockBean
    private MessageRepository messageRepository;

    private MessageService messageService;

    @Before
    public void init() {
        messageService = new MessageServiceImpl(messageRepository);
    }

    @Test
    public void testMessageAdditionToDB() {
        Long id = 1L;
        String message = "message";
        Message msg = new Message();
        msg.setId(id);
        msg.setMessage(message);

        Mockito.when(messageRepository.save(any(Message.class))).thenReturn(new Message(id, message));

        Message savedMsg = messageService.save(msg);

        assertThat(savedMsg.getMessage()).isEqualTo(message);
        assertThat(savedMsg.getId()).isEqualTo(id);
        verify(messageRepository, times(1)).save(any(Message.class));
    }
}
