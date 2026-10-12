<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/dashboard">View Dashboard</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/enquiry">Add Enquiry</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/viewEnquiries">View Enquiries</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/logout">Logout</a>
        </li>
    </ul>
    <hr />
    <a class="nav-link" href="/viewEnquiries">View Enquiries</a>
    <h2>Dashboard Page</h2>

    <table>
        <tr>
            <td>Total Enquiries : </td>
            <td>${dashBoardInfo.totalEnqs}</td>
        </tr>
        <tr>
            <td>Open Enquiries : </td>
            <td>${dashBoardInfo.openEnqs}</td>
        </tr>
        <tr>
            <td>Enrolled Enquiries : </td>
            <td>${dashBoardInfo.enrollEnqs}</td>
        </tr>
        <tr>
            <td>Lost Enquiries : </td>
            <td>${dashBoardInfo.lostEnqs}</td>
        </tr>
    </table>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>