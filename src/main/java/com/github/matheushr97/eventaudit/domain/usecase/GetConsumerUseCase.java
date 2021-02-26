package com.github.matheushr97.eventaudit.domain.usecase;

import com.github.matheushr97.eventaudit.app.repository.ConsumerRepository;
import com.github.matheushr97.eventaudit.domain.model.Consumer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetConsumerUseCase {

    private ConsumerRepository repository;
    private LogConsumerActionUseCase logUseCase;

    public Optional<Consumer> getConsumer(Long id) {
        var maybeConsumer = repository.findByID(id);
        if (maybeConsumer.isPresent()) {
            logUseCase.log(String.valueOf(id), "search");
        }

        return repository.findByID(id);
    }


}
