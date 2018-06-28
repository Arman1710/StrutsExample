package epam.action;

import epam.converter.impl.CommentConverterImpl;
import epam.converter.impl.NewsConverterImpl;
import epam.form.CommentForm;
import epam.form.NewsForm;
import epam.model.dto.NewsDTO;
import epam.model.entity.News;
import epam.services.NewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.util.StringUtils;
import org.springframework.web.struts.MappingDispatchActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class DispatchAction extends MappingDispatchActionSupport {

    private NewsService newsService;

    private NewsConverterImpl newsConverterImpl;

    private CommentConverterImpl commentConverterImpl;

    @Override
    protected void onInit() {
        super.onInit();
        this.newsService = (NewsService) getWebApplicationContext().getBean("newsService");
        this.newsConverterImpl = (NewsConverterImpl) getWebApplicationContext().getBean("newsConverterImpl");
        this.commentConverterImpl = (CommentConverterImpl) getWebApplicationContext().getBean("commentConverterImpl");
    }

    public ActionForward showAllNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        List<News> newsList = newsService.showAllNews();
        for (News news : newsList) {
            newsForm.getNewsList().add(news);
        }
        return mapping.findForward("success");
    }

    public ActionForward selectedNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        NewsForm newsForm = (NewsForm) form;
        NewsDTO newsDTO = newsService.selectedNews(newsId);
       newsConverterImpl.DTOToForm(newsDTO, newsForm);

        return mapping.findForward("success");
    }


    public ActionForward deleteNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        if (newsForm.getCheckboxValue() != null) {
            for (String checkboxValue : newsForm.getCheckboxValue()) {
                newsService.deleteNews(Integer.parseInt(checkboxValue));
            }
        }
        return mapping.findForward("success");
    }

    public ActionForward deleteComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        int newsId = Integer.parseInt(request.getParameter("newsId"));

        if (newsForm.getCheckboxValue() != null) {
            for (String checkboxValue : newsForm.getCheckboxValue()) {
                newsService.deleteComment(newsId, Integer.parseInt(checkboxValue));
            }
        }
        return mapping.findForward("success");
    }

    public ActionForward addComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommentForm commentForm = (CommentForm) form;
        int newsId = Integer.parseInt(request.getParameter("newsId"));

        commentForm.setDateCreated(new Date());
        commentForm.setNewsId(newsId);
        newsService.createComment(newsId, commentConverterImpl.formToDTO(commentForm));

        return mapping.findForward("success");
    }


    public ActionForward moveToEditPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        NewsForm newsForm = (NewsForm) form;

        newsConverterImpl.DTOToForm(newsService.selectedNews(newsId), newsForm);

        return mapping.findForward("success");
    }

    public ActionForward editNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        String newsId = request.getParameter("newsId");

        NewsDTO newsDTO = newsConverterImpl.formToDTO(newsForm);
        newsService.editNews(newsDTO, newsId);

        return mapping.findForward("success");
    }

    public ActionForward addNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;

        NewsDTO newsDTO = newsConverterImpl.formToDTO(newsForm);
        newsService.addNews(newsDTO);

        return mapping.findForward("success");
    }


}
