<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><bean:message key="addNews"/> </title>
</head>
<body>
<html:form action="/addNews?newsId=${newsForm.newsId}">
    <table border="0">
        <thead>
        <tr>
        </tr>
        </thead>
        <tbody>
        <tr> </tr>
        <tr>
            <td><bean:message key="shortDesc"/></td>
            <td><html:text property="shortDesc" value="${newsForm.shortDesc}"/></td>

        </tr>
        <tr>
            <td><bean:message key="fullDesc"/></td>
            <td><html:text property="fullDesc" value="${newsForm.fullDesc}">
            </html:text></td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit>
                <bean:message key="submit"/>
            </html:submit>
            </td>
        </tr>
        </tbody>
    </table>
</html:form>

<html:messages id="short_er" property="shortDesc_err">
    <div style="color:red">
        <bean:write name="short_er" />
    </div>
</html:messages>

<html:messages id="full_err" property="fullDesc_err">
    <div style="color:red">
        <bean:write name="full_err" />
    </div>
</html:messages>

</body>
</html>
