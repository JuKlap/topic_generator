package techxploration.topic_generator.repository.model;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Document("TopicGenerator")
public class TopicDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "question")
    private String question;

    @Column(name = "panik")
    private boolean panicOrNot;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isPanicOrNot() {
        return panicOrNot;
    }

    public void setPanicOrNot(boolean panicOrNot) {
        this.panicOrNot = panicOrNot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
