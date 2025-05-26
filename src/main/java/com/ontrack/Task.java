package com.ontrack;

import java.util.List;

public class Task {
    public String name;
    public String status;
    public String feedback;
    public List<String> chatMessages;

    public Task(String name, String status, String feedback, List<String> chatMessages) {
        this.name = name;
        this.status = status;
        this.feedback = feedback;
        this.chatMessages = chatMessages;
    }
}
