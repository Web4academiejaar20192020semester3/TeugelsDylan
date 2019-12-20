<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library</title>
    <link rel="stylesheet" href="../css/sample.css">
    <meta http-equiv="refresh" content="3; url = /index.jsp"/>
</head>
<body>
<header role="banner"> Error Page</header>
<main>
    <article>
        <h1>Oops!</h1>
    </article>
    <p>${pageContext.exception.message}</p>
    <p>Redirecting ...</p>
</main>
</body>
</html>
