<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Item profile</title>
    <style type="text/css">
        <%@include file="/WEB-INF/front/css/materialize.min.css" %>
        <%@include file="/WEB-INF/front/css/crst.css" %>
    </style>
</head>


<main>

    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo center" href="${base}/cancel">Book profile</a>
        </div>

    </nav>

    <div class="container maxwidth800">

        <div class="errorMessage">
            <p>${requestScope.get("error")}</p>

        </div>

        <div class="container">
            <form action="${base}/itemProfile" method="post">
                <br> Title: <input type="text" name="title" value="${sessionScope.item.title}" placeholder="Title"  required>
                <br> Description: <input type="text" name="description" value="${sessionScope.item.description}"
                                         placeholder="description">
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
