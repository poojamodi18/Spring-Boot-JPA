package org.springBootJPAApp.Spring.Boot.JPA.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    /*private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("ID101","Java","Core Java, Advanced Java"),
            new Topic("ID102","Spring","Spring Framework"),
            new Topic("ID103","Spring Boot","Spring Boot Framework")
    ));*/

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topicsList = new ArrayList<>();
        topicRepository.findAll().forEach(topicsList::add);
        return topicsList;
    }

    public Topic getTopic(String id){
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }


    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
        /*for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }*/
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
