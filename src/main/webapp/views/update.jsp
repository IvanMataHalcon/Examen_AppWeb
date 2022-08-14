<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/08/2022
  Time: 09:20 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../templates/head.jsp"></jsp:include>
</head>
<body>
<div class="container mt-5">
    <div class="row shadow-lg">
        <form class="needs-validation" novalidate action="save-user" method="post">
            <div class="row mb-4 mt-5">
                <div class="col">
                    <div class="form-outline">
                        <input type="text" id="name" class="form-control" name="username" value="${user.username}" />
                        <label class="form-label" for="name">Name</label>
                    </div>
                </div>
                <div class="col">
                    <div class="form-outline">
                        <input type="text" id="curp" name="curp" value="${user.curp}"  class="form-control" />
                        <label class="form-label" for="curp">Curp</label>
                    </div>
                </div>
            </div>
            <div class="form-outline mb-4">
                <input type="text" id="birthday" name="birthday" value="${user.birthday}"  class="form-control" />
                <label class="form-label" for="birthday">Birthday</label>
            </div>
            <button type="button" onclick="location.href = 'get-users'" class="btn btn-danger btn-sm">Cancelar</button>
            <button type="submit" class="btn btn-primary btn-block">Actualizar User</button>
        </form>
        <p style="color: grey;">CREADO POR IVAN SAMUEL MATA NIETO 3C</p>
    </div>
</div>
</body>
</html>

