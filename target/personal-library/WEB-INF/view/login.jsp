<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<%--<c:import url="/WEB-INF/views/commons/Top.jsp" charEncoding="utf-8" />--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Welcome</title>

    <style type="text/css">
        <%@include file="/WEB-INF/front/css/materialize.min.css" %>
        <%@include file="/WEB-INF/front/css/crst.css" %>
    </style>
</head>

<main>

    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo center" href="${base}/userItems">Logo</a>
        </div>

    </nav>

    <%--Error--%>
    <div class="errorMessage">
        <p>${requestScope.get("error")}</p>
    </div>

    <div class="container">
        <form action="${base}/login" class="col" method="post">
            <%--Login--%>
            <div class="row center ">
                <h5 class="header col s12 light"></h5>
                <input class="header col s12 light" type="text" name="login" placeholder="Login:">
            </div>
            <%--Password--%>
            <div class="row center">
                <h5 class="header col s12 light"></h5>
                <input class="header col s12 light" type="password" name="password" placeholder="Password:">
            </div>
            <%--OK--%>
            <div class="row center">
                <h5 class="header col s12 light"></h5>
                <button
                        class="btn-large col s12 waves-effect waves-light red accent-2"
                        type="submit" name="ok" value="Sign In">
                    <i class="material-icons center">Sign in</i>
                </button>
            </div>

            <%--Register--%>
            <div class="row center">
                <i class="material-icons center"> <a href="${base}/userCreate" class="btn col s12 waves-effect waves-light red accent-1">Register</a>
                </i>
            </div>

        </form>
    </div>

</main>
</html>
