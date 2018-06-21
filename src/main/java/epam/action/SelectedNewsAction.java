package epam.action;



import epam.dao.entity.Comments;
import epam.dao.entity.News;
import epam.dao.impl.NewsDAOImpl;
import epam.form.NewsForm;

import epam.services.NewsService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectedNewsAction extends ActionSupport {

    private NewsService newsService;

    @Override
    protected void onInit() {
        super.onInit();
        this.newsService = (NewsService) getWebApplicationContext().getBean("newsService");
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
      int newsId = Integer.parseInt(request.getParameter("newsId"));
      newsService.apply(newsForm, newsId);
      return mapping.findForward("success");
    }

}
