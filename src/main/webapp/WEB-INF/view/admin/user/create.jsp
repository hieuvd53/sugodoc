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
        <title>Create - </title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

        <script>
            $(document).ready(() => {
                const avatarFile = $("#avatarFile");
                avatarFile.change(function (e) {
                    const imgURL = URL.createObjectURL(e.target.files[0]);
                    $("#avatarPreview").attr("src", imgURL);
                    $("#avatarPreview").css({ "display": "block" });
                });
            });
        </script>


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
                        <li class="breadcrumb-item active">Create</li>
                    </ol>
                    <div class="container d-flex justify-content-center align-items-center">
                        <div class="form-container p-4 border rounded shadow bg-white">
                            <form:form action="/admin/user/insert" method="post" modelAttribute="newUser">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="mb-3">
                                            <c:set var="nameHasBindError">
                                                <form:errors path="email" />
                                            </c:set>
                                            <label for="email" class="form-label">Email:</label>
                                            <form:input type="email"
                                                        class="form-control ${not empty nameHasBindError? 'is-invalid':''}"
                                                        path="email"/>
                                            <form:errors path="email" cssClass="invalid-feedback"/>

                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="mb-3">
                                            <c:set var="nameHasBindError">
                                                <form:errors path="password" />
                                            </c:set>

                                            <label for="password" class="form-label">Password:</label>
                                            <form:input type="password"
                                                        class="form-control ${not empty nameHasBindError? 'is-invalid':''}"
                                                        path="password"/>
                                            <form:errors path="password" cssClass="invalid-feedback" />

                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <div class="mb-3">
                                            <label for="fullName" class="form-label">Full Name:</label>
                                            <form:input type="text" class="form-control" path="fullName"/>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="mb-3">
                                            <label for="phone" class="form-label">Phone:</label>
                                            <form:input type="text" class="form-control" path="phone"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="address" class="form-label">Address:</label>
                                    <form:input type="text" class="form-control" path="address"/>
                                </div>

                                <div class="row">
                                    <div class="col-6">
                                        <label class="form-label">Role</label>
                                        <form:select class="form-select" path="role.id">
                                            <c:forEach var="role" items="${roles}">
                                                <form:option value="${role.id}">${role.name}</form:option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="col-6">
                                        <div class="mb-3">
                                            <label for="avatarFile" class="form-label">Default file input example</label>
                                            <input class="form-control" type="file" id="avatarFile" accept=".png,.jpg,.jpeg">
                                          </div>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <img alt="avatar preview" id="avatarPreview" style="max-height: 250px; display:none">
                                    </div>
                                </div>

                                <button type="submit" class="btn btn-success w-100">Create User</button>
                            </form:form>
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
