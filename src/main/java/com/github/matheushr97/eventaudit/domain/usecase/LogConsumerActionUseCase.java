package com.github.matheushr97.eventaudit.domain.usecase;

import com.github.matheushr97.eventaudit.app.repository.ConsumerActionRepository;
import com.github.matheushr97.eventaudit.domain.model.ConsumerActionLog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class LogConsumerActionUseCase {

    private ConsumerActionRepository repository;

    public void log(String consumerID, String action) {
        log(consumerID, action, null);
    }

    public void log(String consumerID, String action, String detail) {
        var actionLog = new ConsumerActionLog()
                .withConsumerID(consumerID)
                .withAction(action)
                .withDetail(detail)
                .withActionDate(Instant.now());
        repository.save(actionLog);
    }

}
