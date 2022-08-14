<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 12/08/2022
  Time: 09:20 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="../templates/head.jsp"></jsp:include>
    <title>USER</title>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <c:if test="${param['result']}">
                <p><c:out value="${param['message']}"></c:out></p>
            </c:if>
            <div class="card  shadow-lg">
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">USUARIOS</div>
                        <div class="col-6 text-end">BY IVAN SAMUEL MATA NIETO</div>
                        <a href="create-user" class="btn btn-outline-success btn-sm">
                            <i data-feather="plus"></i> Registrar user
                        </a>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-sm table-hover datatable">
                        <thead>
                        <th>#</th>
                        <th>User</th>
                        <th>CURP</th>
                        <th>Birthday</th>
                        <th>EDITAR</th>
                        <th>ELIMINAR</th>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <tr>
                                <td>
                                    <c:out value="${status.count}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${user.username}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${user.curp}"/>
                                </td>
                                <td>
                                    <c:out value="${user.birthday}"/>
                                </td>
                                <td>
                                    <a href="get-user?id=${user.id}" class="btn btn-warning btn-sm">EDITAR</a>
                                </td>
                                <td>
                                    <form action="delete-user" method="post">
                                        <input type="hidden" value="${user.id}" name="id"/>
                                        <button type="submit" class="btn btn-danger btn-sm">ELIMINAR</i> </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <p style="color: grey;">CREADO POR IVAN SAMUEL MATA NIETO 3C</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
