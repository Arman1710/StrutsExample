package epam.dao;

import epam.dao.entity.Basic;
import epam.dao.entity.Comments;
import epam.dao.entity.News;

import java.util.List;

public interface BasicDAO<T extends Basic> {
    List<T> read();
    void update (T model);
    void delete (T model);
}
