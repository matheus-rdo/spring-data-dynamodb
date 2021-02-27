package com.github.matheushr97.eventaudit.app.controller;

import com.github.matheushr97.eventaudit.app.repository.ConsumerActionRepository;
import com.github.matheushr97.eventaudit.app.repository.ConsumerRepository;
import com.github.matheushr97.eventaudit.domain.model.Consumer;
import com.github.matheushr97.eventaudit.domain.model.ConsumerActionLog;
import com.github.matheushr97.eventaudit.domain.usecase.GetConsumerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConsumerActionsController {

    private ConsumerActionRepository repository;


    @GetMapping("actions/consumers/{id}")
    public ResponseEntity<List<ConsumerActionLog>> getConsumer(@PathVariable("id") String id) {
        var actionsLog = repository.findByConsumerID(id);
        return ResponseEntity.ok(actionsLog);
    }
}
