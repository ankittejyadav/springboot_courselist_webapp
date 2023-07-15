package com.example.springcoursesapp.course.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("CS101", "Intro", "Beginner"),
            new Topic("CS102", "Algos", "Med"),
            new Topic("CS201", "Adv Prog", "Expert")
        ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public Topic getTopicName(String name){
        return topics.stream().filter(t -> t.getName().equals(name)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for(int i=0;i<topics.size();i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        topics.removeIf(t -> t.getId().equals(id));
    }
}
