package techxploration.topic_generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techxploration.topic_generator.mappers.TopicMapper;
import techxploration.topic_generator.model.Topics;
import techxploration.topic_generator.repository.TopicRepository;
import techxploration.topic_generator.service.TopicService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private TopicRepository topicRepository;


    @Override
    public Topics getRandomQuestion() {

        Long bound = topicRepository.count();
        Long randomNumber = ThreadLocalRandom.current().nextLong(bound);

        return topicRepository.findById(randomNumber).flatMap(topicDAO -> Optional.of(topicMapper.topicDAO_TO_topic(topicDAO)))
                .orElseThrow(() -> new RuntimeException("Topic Not Found"));

    }

    @Override
    public List<Topics> getAllTopics() {
        return null;
    }

    @Override
    public Topics getPanicQuestion() {
        return null;
    }

    @Override
    public List<Topics> getAllQuestionsByTopic() {
        return null;
    }
}
