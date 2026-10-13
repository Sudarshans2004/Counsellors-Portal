<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Enquiry</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <ul class="nav">
        <li class="nav-item"><a class="nav-link" href="/dashboard">View Dashboard</a></li>
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/enquiry">Add Enquiry</a></li>
        <li class="nav-item"><a class="nav-link" href="/viewEnquiries">View Enquiries</a></li>
        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
    </ul>
    <hr />

    <h2>${empty enq.enqId ? 'Add New Enquiry' : 'Edit Enquiry'}</h2>
    <p class="text-success">${smsg}</p>
    <p class="text-danger">${emsg}</p>

    <form:form action="/addEnq" modelAttribute="enq" method="post">
        <form:hidden path="enqId"/>

        <table>
            <tr>
                <td>Student Name :</td>
                <td><form:input path="studentName" cssClass="form-control" required="required"/></td>
            </tr>
            <tr>
                <td>Student Phno :</td>
                <td><form:input path="studentPhone" cssClass="form-control" required="required"/></td>
            </tr>
            <tr>
                <td>Training Mode :</td>
                <td>
                    <form:select path="classMode" cssClass="form-select">
                        <form:option value="Online">Online</form:option>
                        <form:option value="Classroom">Classroom</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Select Course :</td>
                <td>
                    <form:select path="courseName" cssClass="form-select">
                        <form:option value="Java">Java</form:option>
                        <form:option value="Python">Python</form:option>
                        <form:option value="DevOps">DevOps</form:option>
                        <form:option value="AWS">AWS</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Enquiry Status :</td>
                <td>
                    <form:select path="enqStatus" cssClass="form-select">
                        <form:option value="Open">Open</form:option>
                        <form:option value="Enrolled">Enrolled</form:option>
                        <form:option value="Lost">Lost</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit"
                           value="${empty enq.enqId ? 'Add Enquiry' : 'Update Enquiry'}"
                           class="btn btn-primary mt-2"/>
                </td>
            </tr>
        </table>
    </form:form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>