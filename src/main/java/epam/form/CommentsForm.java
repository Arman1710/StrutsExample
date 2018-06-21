package epam.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class CommentsForm extends ActionForm {

    private String author;
    private String description;
    private Date dateCreated;
    private int newsId;
    private int commentsId;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getAuthor() == null || ("".equals(getAuthor()))) {
            errors.add("comAuthor_err",
                    new ActionMessage("error.required.comments.author"));
        }

        if (getDescription() == null || ("".equals(getDescription()))) {
            errors.add("comDesc_err",
                    new ActionMessage("error.required.comments.description"));
        }
        return errors;
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

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }
}
