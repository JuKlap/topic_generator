package techxploration.topic_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TopicGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopicGeneratorApplication.class, args);
    }

}
