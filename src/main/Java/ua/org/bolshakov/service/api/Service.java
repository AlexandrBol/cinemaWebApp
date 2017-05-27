package ua.org.bolshakov.service.api;

import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.dto.UserDTO;


import java.util.List;

public interface Service<K, T>{

    List<T> getAll();

    T getById(K id);

    void save(T entity);

    void delete(K key);

    void update(T entity);

}
