package ru.gb.sem5_homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.sem5_homework.domain.Task;
import ru.gb.sem5_homework.domain.TaskStatus;
import ru.gb.sem5_homework.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @PostMapping("/add-task")
    public Task addTask(@RequestParam String description) {
        return service.addTask(description);
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