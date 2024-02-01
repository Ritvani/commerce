<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22-Dec-23
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>New Card</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="p-5">
    <h1 class="mb-3">New Card</h1>
    <a href="/home">Dashboard</a>
    <div class="bg-light p-5 mt-3">
        <form:form class="form d-flex flex-column gap-3" action="/card/update/${editCard.id}" method="post" enctype="multipart/form-data" modelAttribute="editCard">
            <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                <form:errors path="name" class="errors text-danger"></form:errors>
                <form:label path="name">Card Name: </form:label>
                <form:input class="form-control" path="name" type="text"></form:input>
            </div>
            <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                <form:errors path="description" class="errors text-danger"></form:errors>
                <form:label path="description">Description: </form:label>
                <form:input class="form-control" path="description" type="text"></form:input>
            </div>
            <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                <form:errors path="price" class="errors text-danger"></form:errors>
                <form:label path="price">Price: </form:label>
                <form:input class="form-control" path="price" type="number"></form:input>
            </div>
            <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                <form:errors path="quantity" class="errors text-danger"></form:errors>
                <form:label path="quantity">Quantity: </form:label>
                <form:input class="form-control" path="quantity" type="number"></form:input>
            </div>
            <%--            <div class="d-flex flex-column justify-content-center align-items-center gap-2">--%>
            <%--                <form:errors path="photos" class="errors text-danger"></form:errors>--%>
            <%--                <form:label path="photos">Upload Photo: </form:label>--%>
            <%--                <form:input class="form-control" path="photos" type="file"></form:input>--%>
            <%--            </div>--%>
            <input class="w-50 btn btn-primary align-self-center mt-3" type="submit" value="Submit"/>
        </form:form>
    </div>
</div>
</body>
</html>
