package epam.dao;

import epam.dao.entity.News;


public interface NewsDAO extends BasicDAO<News> {
    News findById(int newsId);
}
