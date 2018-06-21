package epam.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "comments")
public class Comments extends Basic {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "commentsId", nullable = false, updatable = false)
    private int commentsId;

    @Column (nullable = false)
    private String author;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    private Date dateCreated;

    @Column (nullable = false)
    private int newsId;

    @ManyToOne
    @JoinColumn (name = "newsId", insertable = false, updatable = false)
    private News news;

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + commentsId +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", newsId=" + newsId +
                ", news=" + news +
                '}';
    }
}
