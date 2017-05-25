<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Coletas</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Lista de Coletas!</h1>
        <div style="color: red;">${mensagem}</div>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Data</th>
                    <th>Novo Ponto</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="coleta" items="${listColetas}">
                    <tr>
                        <td>${coleta.idColeta}</td>
                        <td>${coleta.descricao}</td>
                        <td>${coleta.dataColeta}</td>
                        <td><a href="novaleitura.html?idColeta=${coleta.idColeta}">P</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
