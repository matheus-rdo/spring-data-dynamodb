package com.github.matheushr97.eventaudit.app.controller;

import com.github.matheushr97.eventaudit.app.repository.ConsumerRepository;
import com.github.matheushr97.eventaudit.domain.model.Consumer;
import com.github.matheushr97.eventaudit.domain.usecase.GetConsumerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConsumerController {

    private ConsumerRepository consumerRepository;
    private GetConsumerUseCase getConsumerUseCase;

    @GetMapping("/consumers")
    public List<Consumer> getConsumers() {
        return consumerRepository.findAll();
    }

    @GetMapping("/consumers/{id}")
    public ResponseEntity<Consumer> getConsumer(@PathVariable("id") Long id) {
        var maybeConsumer = getConsumerUseCase.getConsumer(id);
        return ResponseEntity.of(maybeConsumer); //handles not found
    }
}
