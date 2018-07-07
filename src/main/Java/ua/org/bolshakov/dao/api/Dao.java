package ua.org.bolshakov.dao.api;

import ua.org.bolshakov.model.Entity;

import java.util.List;

public interface Dao<K, T extends Entity<K>> {

    List<T> getAll();

    T getById(K key);

    T getBy(String fieldName, String value);

    void save(T entity);

    void delete(K key);

    void update(T entity);

}
