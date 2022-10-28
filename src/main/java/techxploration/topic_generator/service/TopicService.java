package techxploration.topic_generator.service;

import techxploration.topic_generator.model.Topics;

import java.util.List;

public interface TopicService {

    Topics getRandomQuestion();

    List<Topics> getAllTopics();

    Topics getPanicQuestion();

    List<Topics> getAllQuestionsByTopic();

}
