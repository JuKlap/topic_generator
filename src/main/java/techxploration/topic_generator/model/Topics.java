package techxploration.topic_generator.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Topics {

    private String id;
    private String topic;
    private String question;
    private boolean panicOrNot;

}
