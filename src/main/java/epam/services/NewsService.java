package epam.services;

import epam.converter.impl.CommentConverterImpl;
import epam.converter.impl.NewsConverterImpl;
import epam.dao.impl.NewsDAOImpl;
import epam.model.dto.CommentDTO;
import epam.model.dto.NewsDTO;
import epam.model.entity.Comment;
import epam.model.entity.News;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDAOImpl newsDAOImpl;
    private NewsConverterImpl newsConverterImpl = new NewsConverterImpl();
    private CommentConverterImpl commentImpl = new CommentConverterImpl();
    private final static Logger LOGGER = Logger.getLogger(NewsService.class);

    public List<News> showAllNews() {
        LOGGER.trace("show all news");
        return newsDAOImpl.read();

    }

    public NewsDTO selectedNews(int newsId) {
        LOGGER.info("selected news :" + newsId);
        NewsDTO newsDTO = newsConverterImpl.entityToDTO(newsDAOImpl.findById(newsId));
        LOGGER.trace("Show selected news");
        LOGGER.info("News :" + newsId + " is selected");
        return newsDTO;
    }


    public void deleteNews(int newsId) {
        LOGGER.info("delete news :" + newsId);

        newsDAOImpl.delete(newsDAOImpl.findById(newsId));

        LOGGER.info("News :" + newsId + " is deleted");
    }

    public void deleteComment(final int newsId, final int commentId) {
        LOGGER.info("delete news :" + commentId);
        final News news = newsDAOImpl.findById(newsId);
        final Iterator<Comment> itr = news.getCommentList().iterator();

        while (itr.hasNext()) {
            Comment comment = itr.next();
            if (comment.getCommentId() == commentId) {
                itr.remove();
            }
        }
        newsDAOImpl.saveOrUpdate(news);
        LOGGER.info("News :" + commentId + " is deleted");
    }

    public void createComment(int newsId, CommentDTO commentDTO) {
        LOGGER.info("Creating comment :" + newsId);
        Comment comment = commentImpl.DTOToEntity(commentDTO);
        News news = newsDAOImpl.findById(newsId);
        news.getCommentList().add(comment);
        newsDAOImpl.saveOrUpdate(news);
        LOGGER.trace("Comments :" + news + "is created");
    }

    public void addNews(NewsDTO newsDTO) {
        News news = newsConverterImpl.DTOToEntity(newsDTO);
        newsDAOImpl.create(news);
        LOGGER.trace("News :" + news.getTitle() + "is created");
    }

    public void editNews(NewsDTO newsDTO, String newsId) {
        LOGGER.info("Updating news :" + newsId);
        News news = newsDAOImpl.findById(Integer.parseInt(newsId));
        news.setContent(newsDTO.getContent());
        news.setBrief(newsDTO.getBrief());
        news.setTitle(newsDTO.getTitle());
        newsDAOImpl.saveOrUpdate(news);
        LOGGER.info("News :" + newsId + " is updated");
    }
}


