package techxploration.topic_generator.mappers;

import org.springframework.stereotype.Component;
import techxploration.topic_generator.model.Topics;
import techxploration.topic_generator.repository.model.TopicDAO;

@Component
public class TopicMapper {

    public TopicDAO topic_TO_topicDAO(Topics topics) {
        TopicDAO topicDAO = new TopicDAO();
        if (topics.getId() != null) {
            topicDAO.setId(topics.getId());
        }
        topicDAO.setQuestion(topics.getTopic());
        topicDAO.setPanicOrNot(topics.isPanicOrNot());
        return topicDAO;
    }

    public Topics topicDAO_TO_topic(TopicDAO topicDAO) {
        Topics topic = new Topics();
        topic.setTopic(topicDAO.getTopic());
        topic.setQuestion(topicDAO.getQuestion());
        topic.setPanicOrNot(topicDAO.isPanicOrNot());
        return topic;
    }

}
