package com.ontrack;

import java.util.*;

public class TaskService {
    public List<Task> getSubmittedTasks(String studentId) {
        // Placeholder logic - in real scenario, fetch from DB
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 3", "Submitted", "Good job", List.of("Well done!", "Keep it up")));
        tasks.add(new Task("Task 2", "Submittted", "Needs improvement", List.of("Recheck question 2")));
        tasks.add(new Task("Task 1", "Graded", "Excellent", List.of("Perfect work!")));
        return tasks;
    }
}
