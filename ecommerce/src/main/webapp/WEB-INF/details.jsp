<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23-Dec-23
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Card Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container ml-4 mr-4">
    <div class="d-flex justify-content-between mt-3">
        <h2>Card Details</h2>
        <a href="/home">Home</a>
    </div>
    <div class="d-flex mt-5">
        <p class="mr-5">Card Name:</p>
        <p>${card.name}</p>
    </div>
    <div class="d-flex mt-3">
        <p class="mr-5">Description:</p>
        <p>${card.description}</p>
    </div>
    <div class="d-flex mt-3">
        <p class="mr-5">Added By:</p>
        <p>${card.user.userName}</p>
    </div>
    <div class="d-flex mt-3">
        <p class="mr-5">Price:</p>
        <p>${card.price}</p>
    </div>
    <div class="d-flex mt-3">
        <p class="mr-5">Quantity:</p>
        <p>${card.quantity}</p>
    </div>
    <div class="d-flex justify-content-between mt-5">
        <form:form action="/projects/${card.id}/delete" method="post">
            <button>Delete Card</button>
        </form:form>
    </div>
</div>
</body>
</html>
