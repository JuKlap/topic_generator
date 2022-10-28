package techxploration.topic_generator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import techxploration.topic_generator.repository.model.TopicDAO;

@Repository
public interface TopicRepository extends MongoRepository<TopicDAO, Long> {

}
