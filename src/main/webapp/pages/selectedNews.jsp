<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><bean:message key="selectedNews"/> </title>
</head>
<body>
<html:link action="/main">
    <bean:message key="mainMenu"/>
</html:link>

<html:form action="/editNews?newsId=${newsForm.newsId}">
    <h1>${newsForm.shortDesc}</h1> <br>
        ${newsForm.fullDesc} <br>
    <html:submit>
        <bean:message key="editNews"/>
    </html:submit>
</html:form> <br>

    <html:form action="/addComments?newsId=${newsForm.newsId}">
        <table border="0">
            <thead>
            <tr>
                <th><bean:message key="comments.add"/> </th>
            </tr>
            </thead>
            <tbody>
            <tr> </tr>
            <tr>
                <td><bean:message key="comments.Author"/></td>
                <td><html:text property="author"/></td>
            </tr>
            <tr>
                <td><bean:message key="comments.Description"/></td>
                <td><html:text property="description"/></td>
            </tr>
            <tr>
                <td></td>
                <td><html:submit>
                    <bean:message key="comments.add"/>
                </html:submit>
                </td>
            </tr>
            </tbody>
        </table>
    </html:form>

    <html:messages id="author_err" property="comAuthor_err">
        <div style="color:red">
            <bean:write name="author_err" />
        </div>
    </html:messages>

    <html:messages id="desc_err" property="comDesc_err">
        <div style="color:red">
            <bean:write name="desc_err" />
        </div>
    </html:messages>


    <h1><bean:message key="comments.comments"/></h1>
    <table border="1">
        <c:forEach items="${newsForm.commentsList}" var="comments">
        <html:form action="/deleteComment?newsId=${newsForm.newsId}&commentsId=${comments.commentsId}">
        <thead>

            <th>author ${comments.author} <br></th>

    </thead>
        <tbody>
        <tr>
            <td>
                description ${comments.description}<br>
            </td>
            <td>
                date Created ${comments.dateCreated}<br>
            </td>
            <td><html:submit>
                <bean:message key="comments.delete"/>
            </html:submit>
            </td>
        </tr>

        </tbody>
        </html:form>
        </c:forEach>
    </table>

</body>
</html>
