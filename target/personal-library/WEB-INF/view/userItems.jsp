<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Your books</title>
    <style type="text/css">
        <%@include file="/WEB-INF/front/css/materialize.min.css" %>
        <%@include file="/WEB-INF/front/css/crst.css" %>
    </style>
</head>

<script type="text/javascript">
    /**
     * @return {boolean}
     */
    function DoFunc() {
        var agree = confirm("Are you sure you want to delete this book?");
        if (agree) {
            return true;
        } else {
            return false
        }
     }
</script>


<main>
    <nav>
        <div class="nav-wrapper">
            <a class="brand-logo center" href="${base}/userItems">Book list</a>
            <a href="logout" title="Log out from site" style="padding-left: 90%">Log Out</a>
        </div>

    </nav>

    <div class="container maxwidth800">

        <div class="errorMessage">
            <p>${requestScope.get("error")}</p>

        </div>

        <div style="padding: 0 0 0 85% ">
            <a href="${base}/userEdit" title="Edit your profile"
               class="waves-effect waves-light btn  red accent-2"> ${sessionScope.login} </a>
        </div>


        <div>
            <a href="${base}/itemProfile" title="Add new book"
               class="waves-effect waves-light btn  red accent-2">Add</a>
        </div>


        <div class="row center">
            <div class="col s12">
                <c:choose>
                    <c:when test="${!empty requestScope.itemList}">
                        <table class="highlight">
                            <tr>
                                <th class="titleWidth">Title</th>
                                <th>Description</th>
                                <th class="centerText"></th>
                                <th class="row center"></th>
                            </tr>

                            <c:forEach items="${requestScope.itemList}" var="item">
                                <tr>
                                    <td class="titleWidth">${item.title}</td>
                                    <td>${item.description}</td>
                                    <td class="row center"><a href="${base}/itemEdit?id=<c:out value='${item.id}' />"
                                                              title="Edit book"
                                                              class="waves-effect waves-light btn-small red accent-2">Edit</a></td>
                                    <td class="row center"><a href="${base}/itemDelete?id=<c:out value='${item.id}' />"
                                                              onclick="return confirm('Are you sure you want to delete this item?');"
                                                              title="Delete book"
                                                              class="waves-effect waves-light btn-small  red accent-2">Delete</a>
                                    </td>

                                </tr>
                            </c:forEach>

                        </table>
                    </c:when>
                    <c:otherwise>
                        <h1 class="emptyList">Book list is empty. <br> You must add some books!</h1>
                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </div>
</main>
</html>
