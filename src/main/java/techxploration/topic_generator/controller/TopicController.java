package techxploration.topic_generator.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techxploration.topic_generator.model.Topics;
import techxploration.topic_generator.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("/hackathon")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/random")
    public ResponseEntity<Topics> getRandomQuestion() {
        return new ResponseEntity<>(topicService.getRandomQuestion(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllTopics() {
        return new ResponseEntity<>(topicService.getAllTopics(), HttpStatus.OK);
    }

    @GetMapping("/panic")
    public ResponseEntity<Topics> getPanicQuestion() {
        return new ResponseEntity<>(topicService.getPanicQuestion(), HttpStatus.OK);
    }

    @GetMapping("/{topic}/all")
    public ResponseEntity<List<String>> getAllQuestionsByTopic(@PathVariable @NonNull String topic) {
        return new ResponseEntity<>(topicService.getAllQuestionsByTopic(topic), HttpStatus.OK);
    }
}
