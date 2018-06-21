package epam.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "news")
public class News extends Basic{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "newsId", nullable = false, updatable = false)
    private int newsId;

    @Column (nullable = false)
    private String shortDesc;

    @Column (nullable = false)
    private String fullDesc;


    @OneToMany (mappedBy = "news", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> commentsList = new ArrayList<>();

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", shortDesc='" + shortDesc + '\'' +
                ", fullDesc='" + fullDesc + '\'' +
                ", commentsList=" + commentsList +
                '}';
    }
}
