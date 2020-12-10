<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl">

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Welkom"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="home"/>
</jsp:include>
<div class="background">
<div class="container" style="height: 80vh">
    <main>
        <div class="jumbotron">
            <h1>Homepage</h1>
            <p>This is the homepage.</p>
        </div>
    </main>
</div>

<jsp:include page="footer.jsp"/>
</div>
</body>
</html>