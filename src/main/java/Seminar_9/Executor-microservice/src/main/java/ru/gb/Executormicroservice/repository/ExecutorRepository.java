package ru.gb.Executormicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Executormicroservice.entity.Executor;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Long> {
}