package com.github.matheushr97.eventaudit.app.repository;

import com.github.matheushr97.eventaudit.domain.model.Consumer;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ConsumerRepository {

    private final Map<Long, Consumer> entities = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public ConsumerRepository() {
        this(List.of(
                new Consumer(1l, "Matheus"),
                new Consumer(2l, "João"),
                new Consumer(3l, "Lucas")
        ));
    }

    private ConsumerRepository(List<Consumer> consumers) {
        consumers.forEach(consumer -> save(consumer));
    }

    public List<Consumer> findAll() {
        return new ArrayList<>(entities.values());
    }

    public Optional<Consumer> findByID(Long id) {
        var consumer = entities.get(id);
        if (consumer == null)
            return Optional.empty();

        return Optional.of(consumer);
    }

    public Consumer save(Consumer consumer) {
        if (consumer.getId() == null) {
            consumer.setId(idGenerator.getAndAdd(1));
        }
        entities.put(consumer.getId(), consumer);
        return consumer;
    }

    public int size() {
        return entities.size();
    }

}
