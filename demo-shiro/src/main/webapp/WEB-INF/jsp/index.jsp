<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Index</title>
</head>
<body>
    <%= "Hello World!!! I am JSP" %>
    <br/>
    <shiro:hasPermission name="user:create">
         <a href="/user">User</a><br/>
    </shiro:hasPermission>
    <shiro:hasPermission name="role:create">
         <a href="/role">role</a><br/>
    </shiro:hasPermission>
</body>
</html>
