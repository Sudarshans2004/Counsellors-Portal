<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Dashboard</h2>
        <a href="/logout" class="btn btn-danger">Logout</a>
    </div>

    <div class="row text-center mb-4">
        <div class="col-md-3">
            <div class="card border-primary">
                <div class="card-body">
                    <h6>Total Enquiries</h6>
                    <h3>${dashBoardInfo.totalEnq}</h3>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card border-warning">
                <div class="card-body">
                    <h6>Open</h6>
                    <h3>${dashBoardInfo.openEnq}</h3>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card border-success">
                <div class="card-body">
                    <h6>Enrolled</h6>
                    <h3>${dashBoardInfo.enrolledEnq}</h3>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card border-danger">
                <div class="card-body">
                    <h6>Lost</h6>
                    <h3>${dashBoardInfo.lostEnq}</h3>
                </div>
            </div>
        </div>
    </div>

    <a href="/addEnquiry" class="btn btn-primary">Add Enquiry</a>
    <a href="/viewEnquiries" class="btn btn-secondary">View Enquiries</a>

</div>
</body>
</html>