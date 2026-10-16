<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View Enquiries</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <ul class="nav">
        <li class="nav-item"><a class="nav-link" href="/dashboard">View Dashboard</a></li>
        <li class="nav-item"><a class="nav-link" href="/enquiry">Add Enquiry</a></li>
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/viewEnquiries">View Enquiries</a></li>
        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
    </ul>
    <hr />

    <a href="/enquiry">Add New Enquiry</a>
    <h2>View Enquiries Here</h2>

    <!-- Filters (they work once the filter step is added) -->
    <form action="/viewEnquiries" method="get" class="mb-3">
        Class Mode :
        <select name="classMode">
            <option value="">-Select-</option>
            <option value="Online"    ${param.classMode == 'Online'    ? 'selected' : ''}>Online</option>
            <option value="Classroom" ${param.classMode == 'Classroom' ? 'selected' : ''}>Classroom</option>
        </select>

        Course :
        <select name="courseName">
            <option value="">-Select-</option>
            <option value="Java"   ${param.courseName == 'Java'   ? 'selected' : ''}>Java</option>
            <option value="Python" ${param.courseName == 'Python' ? 'selected' : ''}>Python</option>
            <option value="DevOps" ${param.courseName == 'DevOps' ? 'selected' : ''}>DevOps</option>
            <option value="AWS"    ${param.courseName == 'AWS'    ? 'selected' : ''}>AWS</option>
        </select>

        Status :
        <select name="enqStatus">
            <option value="">-Select-</option>
            <option value="Open"     ${param.enqStatus == 'Open'     ? 'selected' : ''}>Open</option>
            <option value="Enrolled" ${param.enqStatus == 'Enrolled' ? 'selected' : ''}>Enrolled</option>
            <option value="Lost"     ${param.enqStatus == 'Lost'     ? 'selected' : ''}>Lost</option>
        </select>

        <input type="submit" value="Search" class="btn btn-primary"/>
    </form>

    <table class="table table-bordered">
        <thead>
            <tr>
                <th>S.No</th>
                <th>Name</th>
                <th>Course</th>
                <th>Mode</th>
                <th>Phno</th>
                <th>Status</th>
                <th>Edit</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach items="${enquiries}" var="enq" varStatus="loopCounter">
               <tr>
                   <td>${loopCounter.index + 1}</td>
                   <td>${enq.studentName}</td>
                   <td>${enq.courseName}</td>
                   <td>${enq.classMode}</td>
                   <td>${enq.studentPhone}</td>
                   <td>${enq.enqStatus}</td>
                   <td><a href="/editEnquiry?enqId=${enq.enqId}">Edit</a></td>
               </tr>
           </c:forEach>

            <c:if test="${empty enquiries}">
                <tr>
                    <td colspan="7" class="text-center">No Records Found</td>
                </tr>
            </c:if>
        </tbody>
    </table>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>