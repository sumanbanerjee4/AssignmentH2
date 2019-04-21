package com.example.assignment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {

    public static ResponseEntity<String> createResponseEntity(String message, HttpStatus statusCode) {
        return new ResponseEntity<>(message, statusCode);
    }

    public static <T> Optional<T> findOneById(CrudRepository<T, Long> repo, Long id) {
        return repo.findById(id);
    }

    public static <T> T save(CrudRepository<T, Long> repo, T entity) {
        return repo.save(entity);
    }

}