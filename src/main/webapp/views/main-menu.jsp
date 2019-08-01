<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: lightskyblue">
    <a class="navbar-bran mr-2" href="https://github.com/TommKow">TommKow</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav nav nav-pills nav-fill">
            <li class="nav-item active mx-1">
                <a class="nav-link btn btn-outline-info" role="button" href="/"><span
                        class="text-lg-left">Strona główna</span></a>
            </li>

        </ul>
    </div>
    <sec:authorize access="!isAuthenticated()">
        <div style="margin-right: 20px"> Witaj, <strong>nieznajomy</strong></div>
        <form class="form-inline mr-2 mt-3" method="get" action="/login">
            <button class="btn btn-outline-primary" type="submit">Zaloguj</button>
        </form>
        <form class="form-inline mt-3" method="get" action="/register">
            <button class="btn btn-outline-success" type="submit">Zarejestruj</button>
        </form>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div style="margin-right: 20px"> Witaj, <strong>${pageContext.request.userPrincipal.principal.username}</strong></div>
        <form class="form-inline mt-3" method="post" action="/logout">
            <button class="btn btn-outline-primary" type="submit">Wyloguj</button>
        </form>

            <a href="/user-adverts/${userId}">Twoje ogłoszenia</a>

    </sec:authorize>
</nav>