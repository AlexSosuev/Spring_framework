package com.example.CRUD.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Before("@annotation(com.example.CRUD.aspects.TrackUserAction)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Перед выполнением метода: " + joinPoint.getSignature());
    }

    @Around("@annotation(com.example.CRUD.aspects.TrackUserAction)")
    public Object logAfter(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = new Date().getTime();
        Object result = joinPoint.proceed();
        long endTime = new Date().getTime();

        String methodName = joinPoint.getSignature().toShortString();
        String[] parameterNames = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .toArray(String[]::new);

        System.out.println("Метод: " + methodName + ", Параметры: " + parameterNames + ", Занял: " + (endTime - startTime) + "мс");

        return result;
    }
}