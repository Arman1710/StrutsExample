package epam.action;

import epam.form.NewsForm;
import epam.services.NewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllNewsAction extends ActionSupport{

    NewsService newsService;

    @Override
    protected void onInit() {
        super.onInit();
        this.newsService = (NewsService) getWebApplicationContext().getBean("newsService");
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        System.out.println(newsService.getClass());
        newsService.showAllNews(newsForm);
        return mapping.findForward("success");
    }

}
