<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Patient Details"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="register"/>
</jsp:include>

<div class="background" style="height: 80vh">
<div class="container jumbotron" style="background: #e9eceff1">
    <main>
        <form method="post" action="Controller?command=Register">
            <p>
                <label for="price">Price</label>
                <input type="number" id="price" name="price">
            </p>
            <p>
                <label for="name">Name</label>
                <input type="text" id="name" name="name">
            </p>
            <p>
                <label for="category">category</label>
                <input type="category" id="category"  name="category">
            </p>
            <p>
                <label for="vegetarian">vegetarian</label>
                <input type="checkbox" id="vegetarian" name="vegetarian">
            </p>
            <p>
                <label for="containsLactose">contains Lactose</label>
                <input type="checkbox" id="containsLactose" name="containsLactose">
            </p>
            <p>
                <label for="containsNuts">contains Nuts</label>
                <input type="checkbox" id="containsNuts" name="containsNuts">
            </p>
            <p>
                <input type="submit" id="register" value="Register">
            </p>
        </form>
    </main>
</div>

<jsp:include page="footer.jsp"/>
</div>
</body>
</html>