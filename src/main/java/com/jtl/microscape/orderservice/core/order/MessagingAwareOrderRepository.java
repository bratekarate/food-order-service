package com.jtl.microscape.orderservice.core.order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("orderRepository")
public class MessagingAwareOrderRepository implements OrderRepository {

    public MessagingAwareOrderRepository(@Qualifier("internalOrderRepository") OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    private final OrderRepository orderRepository;

    @Override
    @NonNull
    public <S extends Order> S save(@NonNull S entity) {
        return orderRepository.save(entity);
        // todo: insert messaging logic
    }

    @Override
    @NonNull
    public <S extends Order> Iterable<S> saveAll(@NonNull Iterable<S> entities) {
        return orderRepository.saveAll(entities);
        // todo: insert messaging logic
    }

    @Override
    @NonNull
    public Optional<Order> findById(@NonNull Long aLong) {
        return orderRepository.findById(aLong);
    }

    @Override
    public boolean existsById(@NonNull Long aLong) {
        return orderRepository.existsById(aLong);
    }

    @Override
    @NonNull
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @NonNull
    public Iterable<Order> findAllById(@NonNull Iterable<Long> longs) {
        return orderRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public void deleteById(@NonNull Long aLong) {
        orderRepository.deleteById(aLong);
        // todo: insert messaging logic
    }

    @Override
    public void delete(@NonNull Order entity) {
        orderRepository.delete(entity);
        // todo: insert messaging logic
    }

    @Override
    public void deleteAll(@NonNull Iterable<? extends Order> entities) {
        orderRepository.deleteAll(entities);
        // todo: insert messaging logic
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
        // todo: insert messaging logic
    }

    @Override
    @NonNull
    public Iterable<Order> findAll(@NonNull Sort sort) {
        return orderRepository.findAll(sort);
    }

    @Override
    @NonNull
    public Page<Order> findAll(@NonNull Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
