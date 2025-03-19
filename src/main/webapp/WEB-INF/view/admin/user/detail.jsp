<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content=" - Dự án laptopshop" />
        <meta name="author" content="" />
        <title>Dashboard - </title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </head>
<body>
    <jsp:include page="../layout/header.jsp"/>
    <div id="layoutSidenav">
        <jsp:include page="../layout/sidebar.jsp"/>
        <div id="layoutSidenav_content">
            <main>
                <div class="container mt-4">
                    <h1 class="mt-4">Manage Users</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                        <li class="breadcrumb-item "><a href="/admin/user">Users</a></li>
                        <li class="breadcrumb-item active">Detail</li>
                    </ol>
                    <div class="container d-flex justify-content-center align-items-center">
                        <div class="form-container p-4 border rounded shadow bg-white">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email:&nbsp</label>${user.email}
                            </div>
                            <div class="mb-3">
                                <label for="fullName" class="form-label">Full Name:&nbsp</label>${user.fullName}
                            </div>
                            <div class="mb-3">
                                <label for="address" class="form-label">Address:&nbsp</label>${user.address}
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone:&nbsp</label>${user.phone}
                            </div>
                            <a href="/admin/user" class="btn btn-primary">Back</a>
                        </div>
                    </div>
                </div>
            </main>
            <jsp:include page="../layout/footer.jsp"/>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="/js/scripts.js"></script>
</body>
</html>
