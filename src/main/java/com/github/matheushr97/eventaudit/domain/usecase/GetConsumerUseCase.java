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

    public Optional<Consumer> getConsumer(Long id) {
        return repository.findByID(id);
    }


}
