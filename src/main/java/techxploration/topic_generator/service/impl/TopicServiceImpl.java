package techxploration.topic_generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import techxploration.topic_generator.mappers.TopicMapper;
import techxploration.topic_generator.model.Topics;
import techxploration.topic_generator.repository.TopicRepository;
import techxploration.topic_generator.repository.model.TopicDAO;
import techxploration.topic_generator.service.TopicService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topics getRandomQuestion() {
        Long randomNumber = ThreadLocalRandom.current().nextLong(topicRepository.count());
        List<TopicDAO> topics = topicRepository.findAll();
        TopicDAO topicDAO = topics.get(Math.toIntExact(randomNumber));
        return topicMapper.topicDAO_TO_topic(topicDAO);
    }

    @Override
    public List<String> getAllTopics() {
        List<Topics> allTopics = topicRepository.findAll().stream().map(topicMapper::topicDAO_TO_topic).collect(Collectors.toList());
        List<String> justTopics = new ArrayList<>();
        allTopics.forEach(topics -> justTopics.add(topics.getTopic()));
        return justTopics.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Topics getPanicQuestion() {
        List<Topics> panicQuestions = topicRepository.findAll().stream()
                .filter(TopicDAO::isPanicOrNot)
                .map(topicMapper::topicDAO_TO_topic)
                .collect(Collectors.toList());

        Long randomNumber = ThreadLocalRandom.current().nextLong(panicQuestions.size());
        return panicQuestions.get(Math.toIntExact(randomNumber));
    }

    @Override
    public List<String> getAllQuestionsByTopic(String topic) {
        if (StringUtils.isEmpty(topic)) {
            throw new RuntimeException("Topic should not be empty");
        }
        List<Topics> allTopicsByTopic = topicRepository.findAll().stream()
                .filter(topicDAO -> topicDAO.getTopic().equalsIgnoreCase(topic))
                .map(topicMapper::topicDAO_TO_topic)
                .collect(Collectors.toList());

        List<String> justQuestions = new ArrayList<>();
        allTopicsByTopic.forEach(topics -> justQuestions.add(topics.getQuestion()));

        return justQuestions;
    }
}
