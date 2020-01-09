package pavel.efimov.consumer;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "message_table")
@Data
public class Message {

    public Message() {

    }

    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;
}
