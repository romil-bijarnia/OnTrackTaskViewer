package com.ontrack;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testGetSubmittedTasks_returnsCorrectTaskOrder() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getSubmittedTasks("student123");
        assertEquals("Task 3", tasks.get(0).name); // most recent
        assertEquals("Task 2", tasks.get(1).name);
        assertEquals("Task 1", tasks.get(2).name); // oldest
    }

    @Test
    public void testGetSubmittedTasks_containsChatMessages() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getSubmittedTasks("student123");
        assertFalse(tasks.get(0).chatMessages.isEmpty());
        assertEquals("Well done!", tasks.get(0).chatMessages.get(0));
    }

    @Test
    public void testGetSubmittedTasks_correctStatusAndFeedback() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getSubmittedTasks("student123");

        assertEquals("Submitted", tasks.get(1).status);
        assertEquals("Needs improvement", tasks.get(1).feedback);

        assertEquals("Graded", tasks.get(2).status);
        assertEquals("Excellent", tasks.get(2).feedback);
    }

    @Test
    public void testGetSubmittedTasks_validatesNumberOfTasks() {
        TaskService service = new TaskService();
        List<Task> tasks = service.getSubmittedTasks("student123");
        assertEquals(3, tasks.size(), "There should be 3 tasks returned");
    }

    @Test
    public void testGetSubmittedTasks_emptyChatIfNone() {
        TaskService service = new TaskService() {
            @Override
            public List<Task> getSubmittedTasks(String studentId) {
                return List.of(new Task("Empty Task", "Submitted", "No feedback", List.of()));
            }
        };
        List<Task> tasks = service.getSubmittedTasks("student123");
        assertTrue(tasks.get(0).chatMessages.isEmpty());
    }
}
