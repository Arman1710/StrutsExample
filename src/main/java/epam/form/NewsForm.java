package epam.form;

import epam.dao.entity.Comments;
import epam.dao.entity.News;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class NewsForm extends ActionForm {
    private List<News> newsList = new ArrayList<>();
    private String shortDesc;
    private String fullDesc;
    private String error;
    private int newsId;
    private List<Comments> commentsList = new ArrayList<>();

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getShortDesc() == null || ("".equals(getShortDesc()))) {
            errors.add("shortDesc_err",
                    new ActionMessage("error.required.shortDesc"));
        }

        if (getFullDesc() == null || ("".equals(getFullDesc()))) {
            errors.add("fullDesc_err",
                    new ActionMessage("error.required.fullDesc"));
        }
        return errors;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}

