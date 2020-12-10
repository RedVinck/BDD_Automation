<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Patient Overview"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="persons"/>
</jsp:include>
<div class="background">
<div class="container" style="height: 80vh">
    <main>
        <h1>All meals</h1>
        <c:choose>
            <c:when test="${not empty meals}">
                <table class="table table-striped">
                    <thead class="thead-light">
                    <tr>
                       <th>name</th>
                        <th>category</th>
                        <th>containsNuts</th>
                        <th>vegetarian</th>
                        <th>containsLactose</th>
                        <th>price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="patient" items="${meals}">
                        <tr>
                            <td><c:out value='${patient.name}'/></td>
                            <td><c:out value='${patient.category}'/></td>
                            <td><c:out value='${patient.containsNuts}'/></td>
                            <td><c:out value='${patient.vegetarian}'/></td>
                            <td><c:out value='${patient.containsLactose}'/></td>
                            <td><c:out value='${patient.price}'/></td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p id="NoMealsFound"><em>No Meals found</em></p>
            </c:otherwise>
        </c:choose>
    </main>
</div>

<jsp:include page="footer.jsp"/>
</div>
</body>
</html>