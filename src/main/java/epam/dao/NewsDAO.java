package epam.dao;

import epam.model.entity.News;


public interface NewsDAO extends BasicDAO<News> {
    News findById(int newsId);
}
