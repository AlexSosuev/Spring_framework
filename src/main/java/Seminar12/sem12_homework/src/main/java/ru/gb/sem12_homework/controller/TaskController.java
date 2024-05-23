package ru.gb.sem12_homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import ru.gb.sem12_homework.domain.Task;
import ru.gb.sem12_homework.domain.TaskStatus;
import ru.gb.sem12_homework.service.TaskService;

import org.springframework.messaging.MessageChannel;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;
    private final MessageChannel taskChannel;

    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @PostMapping("/add-task")
    public void addTask(@RequestParam String description) {
        taskChannel.send(MessageBuilder.withPayload(description).build());
    }

    @GetMapping("status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return service.getTaskByStatus(status);
    }

    @PutMapping("update-task/{id}/{status}")
    public Task updateTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status) {
        return service.updateTaskStatus(id, status);
    }

    @DeleteMapping("delete-task/{id}")
    public String deleteTaskById(@PathVariable Long id) {
        service.removeTask(id);
        return "Task deleted";
    }
}