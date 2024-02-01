<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21-Dec-23
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-between mt-2">
        <h1>Welcome, ${user.userName}!</h1>
        <div class="d-inline p-2">
            <a href="/logout">Logout</a>
        </div>
    </div>

    <div class="mt-5">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Image</th>
                <th>Name</th>
                <th>Description</th>
                <th>Added By</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>

            </thead>
            <tbody>
            <c:forEach var="card" items="${topCards}">
                <tr>
                    <td><img src="data:image/jpg;base64 base64_encode ${card.photo}" alt="photo"/></td>
                    <td><a href="/card/${card.id}"><c:out value="${card.name}"/></a></td>
                    <td><c:out value="${card.description}"/></td>
                    <td><c:out value="${card.user.userName}"/></td>
                    <td> <fmt:formatNumber type="currency" value="${card.price}" currencyCode="USD"/></td>
                    <td><c:out value="${card.quantity}"/></td>
                    <c:if test="${card.user.id==user.id}">
                        <td><a href="/card/edit/${card.id}">Edit</a></td>
                        <td><a href="/card/delete/${card.id}">Delete</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="w-100 btn align-self-center mt-3"><a href="/new/card">New Card</a></button>
    </div>
</div>
</body>
</html>
