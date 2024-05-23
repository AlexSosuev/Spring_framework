package ru.gb.sem12_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.gb.sem12_homework", "ru.gb.sem12_homework.integration"})
public class Sem12HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sem12HomeworkApplication.class, args);
	}
}