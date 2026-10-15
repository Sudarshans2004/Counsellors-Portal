<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5" style="max-width: 500px;">
    <h2>Login Here</h2>
    <p class="text-danger">${emsg}</p>

    <form:form action="/login" modelAttribute="counsellor" method="post">
        <table>
            <tr>
                <td>Email :</td>
                <td><form:input path="email" type="email" cssClass="form-control" required="required"/></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><form:password path="pwd" cssClass="form-control" required="required"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Login" class="btn btn-primary"/></td>
            </tr>
        </table>
    </form:form>

    <p class="mt-3">New user? <a href="/register">Register here</a></p>
</div>
</body>
</html>