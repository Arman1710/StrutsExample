package epam.dao.impl;

import epam.dao.NewsDAO;
import epam.dao.entity.News;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<News> read() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List newsListDAO = session.createQuery("FROM News").list();

        session.getTransaction().commit();
        session.close();

        return newsListDAO;
    }

    @Override
    public void update(News news) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println(news.getCommentsList().size());
        session.saveOrUpdate(news);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(News news) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(news);

        session.getTransaction().commit();
        session.close();
    }


    @Override
    public News findById(int newsId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        News news = session.get(News.class, newsId);

        session.getTransaction().commit();
        session.close();

        return news;
    }
}
