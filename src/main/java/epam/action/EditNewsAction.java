package epam.action;

import epam.form.NewsForm;
import epam.services.NewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditNewsAction extends ActionSupport {

    private NewsService newsService;

    @Override
    protected void onInit() {
        super.onInit();
        this.newsService = (NewsService) getWebApplicationContext().getBean("newsService");
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        NewsForm newsForm = (NewsForm) form;
        newsService.apply(newsForm, newsId);
        return mapping.findForward("success");
    }
}
