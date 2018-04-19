<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>User profile</title>
    <style type="text/css">
        <%@include file="/WEB-INF/front/css/materialize.min.css" %>
        <%@include file="/WEB-INF/front/css/crst.css" %>
    </style>
</head>

<main>

    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo center" href="${base}/cancel" >User profile</a>
        </div>
    </nav>

    <div class="container maxwidth800">
        <div class="errorMessage">
            <p>${requestScope.get("error")}</p>
        </div>
        <div class="container">
            <form action="${base}/userProfile" method="post">
                <br> Login: <input type="text" name="login"
                                   pattern="[A-Za-z0-9]{1,}"
                                   title="Only letters and digits"
                                   value="${sessionScope.user.login}" placeholder="login" required>
                <br> Email: <input type="text" name="email"
                                   pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
                                   title="Must match this format:
                                    example@example.example"
                                   value="${sessionScope.user.email}" placeholder="email" required>
                <br> Last Name: <input type="text" name="lastName"
                                       pattern="[A-Za-z]{1,}"
                                       title="Only letters."
                                       value="${sessionScope.user.lastName}"
                                       placeholder="last name">
                <br> Password: <input type="password" name="password"
                                      pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                      title="Must contain at least one number and one uppercase and
                              lowercase letter, and at least 8 or more characters"
                                      value="${sessionScope.user.password}" placeholder="password" required>
                <br> Confirm password: <input type="password" name="confirm_password" placeholder="confirm_password"  required>

                <div class="row center">
                    <h5 class="header col s12 light"></h5>
                    <button
                            class="btn-large col s12 waves-effect waves-light red accent-2"
                            type="submit" name="ok" value="Sign In">
                        <i class="material-icons center">OK</i>
                    </button>
                </div>
                <div class="row center">
                    <i class="material-icons center">
                        <a href="${base}/cancel" class="btn col s12 waves-effect waves-light red accent-1">Cancel</a>
                    </i>
                </div>
            </form>
        </div>
    </div>
</main>
</html>
