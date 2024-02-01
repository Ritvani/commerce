<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21-Dec-23
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Login and Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="d-flex flex-column justify-content-center align-items-center gap-2">
        <h1 class="mt-5">Welcome, House Hunter</h1>
    </div>
    <div class="d-flex justify-content-center gap-5 mt-3">
        <div class="bg-light p-5">
            <h3>Register</h3>

            <form:form class="form d-flex flex-column gap-3" action="/register" method="post" modelAttribute="newUser">
                <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="userName" class="errors text-danger"></form:errors>
                    <form:label path="userName">User Name: </form:label>
                    <form:input class="form-control" path="userName" type="text"></form:input>
                </div>
                <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="email" class="errors text-danger"></form:errors>
                    <form:label path="email">Email: </form:label>
                    <form:input class="form-control" path="email" type="text"></form:input>
                </div>
                <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="password" class="errors text-danger"></form:errors>
                    <form:label path="password">Password: </form:label>
                    <form:input class="form-control" path="password" type="password"></form:input>
                </div>
                <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="confirm" class="errors text-danger"></form:errors>
                    <form:label path="confirm">Confirm PW: </form:label>
                    <form:input class="form-control" path="confirm" type="password"></form:input>
                </div>
                <input class="w-50 btn btn-primary align-self-center mt-3" type="submit" value="Register"/>
            </form:form>
        </div>
        <div class="bg-light p-5">
            <h3>Login</h3>
            <form:form class="form d-flex flex-column gap-3" action="/login" method="post" modelAttribute="newLogin">
                <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="email" class="errors text-danger"></form:errors>
                    <form:label path="email">Email: </form:label>
                    <form:input class="form-control" path="email" type="text"></form:input>
                </div>
                <div class="d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="password" class="errors text-danger"></form:errors>
                    <form:label path="password">Password: </form:label>
                    <form:input class="form-control" path="password" type="password"></form:input>
                </div>
                <input class="w-50 btn btn-primary align-self-center mt-3" type="submit" value="Log in"/>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
