<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-md navbar-light bg-light mb-4">
        <a class="navbar-brand" href="Controller">

            <img
                    src="img/logo.png"
                    alt="logo"
                    height="70"
                    width="200" />
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
            <ul class="navbar-nav mr-auto">
                    <li class="nav-item<c:if test="${param.activePage eq 'persons'}"> active</c:if>">
                        <a class="nav-link" href="${pageContext.request.contextPath }/Controller?command=Overview">Meal Menu</a>
                    </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item<c:if test="${param.activePage eq 'register'}"> active</c:if>">
                    <a class="nav-link" href="${pageContext.request.contextPath }/Controller?command=SignUp">Add Meal</a>
                </li>
            </ul>
        </div>
    </nav>
</header>