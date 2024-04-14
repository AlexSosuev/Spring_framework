package ru.gb.sem5_homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.sem5_homework.domain.Task;
import ru.gb.sem5_homework.domain.TaskStatus;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {
    List<Task> getTaskByStatus(TaskStatus status);
}