package ru.gb.sem12_homework.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
public class TaskIntegrationFlow {

    @Bean
    public MessageChannel taskChannel() {
        return MessageChannels.direct().get();
    }

    @Bean
    public IntegrationFlow taskFlow() {
        return IntegrationFlows.from("taskChannel")
                .handle("taskService", "addTask")
                .get();
    }
}