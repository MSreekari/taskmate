package com.taskmate.controller;

import com.taskmate.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class TaskController {

    @GetMapping("/hello")
    public String hello() {
        return "hello from TaskController";
    }

    private final List<Task> taskList = new ArrayList<>();

    //https://localhost:8081/home/tasks
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskList;
    }

    @PostMapping
    public String addTask(@RequestBody Task task) {
        taskList.add(task);
        return "task added successfully";
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskList.stream()
                .filter(task -> task.getId() != null && task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        for(Task task : taskList){
            if(task.getId().equals(id)){
                task.setId(id++);
                task.setName(updatedTask.getName());
                task.setCompleted(updatedTask.isCompleted());
            }
        }
        return "task updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskList.removeIf(task -> task.getId().equals(id));
        return "task deleted successfully";
    }
}
