package ru.gb.sem5_homework.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.sem5_homework.domain.Task;
import ru.gb.sem5_homework.domain.TaskStatus;
import ru.gb.sem5_homework.repository.TasksRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class TaskService {

    private final TasksRepository repository;

    private final AtomicLong count = new AtomicLong();

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(String description) {
        Task task = new Task(count.incrementAndGet(), description, TaskStatus.NOT_STARTED, LocalDateTime.now());
        return repository.save(task);
    }

    public List<Task> getTaskByStatus(TaskStatus status) {
        return repository.getTaskByStatus(status);
    }

    public Task updateTaskStatus(Long id, TaskStatus taskStatus) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Задание не найдено"));
        task.setStatus(taskStatus);
        return repository.save(task);
    }

    public void removeTask(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Задание не найдено"));
        repository.deleteById(id);
    }
}