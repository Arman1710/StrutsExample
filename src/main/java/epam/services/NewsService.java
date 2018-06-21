package epam.services;

import epam.dao.entity.Comments;
import epam.dao.entity.News;
import epam.dao.impl.NewsDAOImpl;
import epam.form.CommentsForm;
import epam.form.NewsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService{
    @Autowired
    NewsDAOImpl newsDAOImpl;

    public NewsForm showAllNews( NewsForm newsForm){
        List<News> newsList = newsDAOImpl.read();
        for (News news: newsList){
            newsForm.getNewsList().add(news);
        }
        return newsForm;
    }

    public void apply (NewsForm newsForm, int newsId) {
        News news = newsDAOImpl.findById(newsId);
        newsForm.setNewsId(news.getNewsId());
        newsForm.setShortDesc(news.getShortDesc());
        newsForm.setFullDesc(news.getFullDesc());
        for (Comments comments : news.getCommentsList()) {
            newsForm.getCommentsList().add(comments);
        }
    }

    public void delete(int newsId) {
        newsDAOImpl.delete(newsDAOImpl.findById(newsId));
    }

    public void update(int newsId, int commentsId) {
        News news = newsDAOImpl.findById(newsId);
        for (Comments comments: news.getCommentsList()){
            if(comments.getCommentsId() == commentsId) {
                news.getCommentsList().remove(comments);
                break;
            }
        }
        newsDAOImpl.update(news);
    }

    public void createComment (int newsId, CommentsForm commentsForm) {
        News news = newsDAOImpl.findById(newsId);
        Comments comments = new Comments();
        comments.setAuthor(commentsForm.getAuthor());
        comments.setDescription(commentsForm.getDescription());
        comments.setDateCreated(commentsForm.getDateCreated());
        comments.setNewsId(news.getNewsId());
        news.getCommentsList().add(comments);
        newsDAOImpl.update(news);
    }

    public void addNews (String newsId, NewsForm newsForm) {
        if (newsId.isEmpty()) {
            News news = new News();
            news.setShortDesc(newsForm.getShortDesc());
            news.setFullDesc(newsForm.getFullDesc());
            newsDAOImpl.update(news);

        } else {

            News news = newsDAOImpl.findById(Integer.parseInt(newsId));
            news.setShortDesc(newsForm.getShortDesc());
            news.setFullDesc(newsForm.getFullDesc());
            for (Comments comments : newsForm.getCommentsList()) {
                news.getCommentsList().add(comments);
            }
            newsDAOImpl.update(news);
        }
    }

}

