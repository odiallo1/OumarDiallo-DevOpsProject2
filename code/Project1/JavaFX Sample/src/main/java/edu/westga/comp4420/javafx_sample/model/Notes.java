package edu.westga.comp4420.javafx_sample.model;

import java.util.HashSet;
import java.util.Set;

public class Notes {
    private String id;
    private String text;
    private Set<String> topics;

    public Notes() {
        this.id = java.util.UUID.randomUUID().toString();
        this.text = "Hello World";
        this.topics = new HashSet<>();
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getTopics() {
        return this.topics;
    }

    public boolean addTopic(String topic) {
        if (topic == null || topic.isEmpty() || this.topics.contains(topic)) {
            return false;
        }
        this.topics.add(topic);
        return true;
    }

    public boolean removeTopic(String topic) {
        return this.topics.remove(topic);
    }
    
    @Override
    public String toString() {
        
        return this.text.isEmpty() ? "New Note" : this.text;
    }

}
