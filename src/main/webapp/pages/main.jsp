<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>News main page</title>
</head>
<body>


<table>
    <c:forEach items="${newsForm.newsList}" var="news">
    <tbody>
    <tr>
        <td>
            <html:link action="/selectedNews?newsId=${news.newsId}">
                <h1> ${news.shortDesc} </h1> <br>
            </html:link>
        </td>
        <td>

        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>

<html:form action="/deleteNews?newsId=${news.newsId}" >
    <html:submit>
        Remove this news
    </html:submit>
</html:form>

<html:link page="pages/addNews.jsp">
    Click to add news
</html:link>

</body>
</html>
