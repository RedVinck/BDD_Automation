<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Something Wrong</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
</header>
<main id="container card">
  <div class="container">
        <div class="card"><p>You caused a ${pageContext.exception} on the server.</p>
            <p>Go <a href="Controller?command=.HomePage">home</a>.</p>
        </div>
    </div>

</body>
</html>
