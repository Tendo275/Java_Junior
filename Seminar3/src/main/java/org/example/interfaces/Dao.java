package org.example.interfaces;

import java.util.List;

public interface Dao<T> {
    List<T> index();

    void save(T object);

    T show(int id);

    void update(int id, T object);

    void delete(int id);
}
