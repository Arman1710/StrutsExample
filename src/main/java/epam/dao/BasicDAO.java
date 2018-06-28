package epam.dao;

import epam.model.entity.Basic;

import java.util.List;

public interface BasicDAO<T extends Basic> {
    List<T> read();
    void saveOrUpdate(T model);
    void delete (T model);
    void create (T model);

}
