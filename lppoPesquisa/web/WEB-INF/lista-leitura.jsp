<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pontos de Leituras</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Pontos de Leituras!</h1>
        <div style="color: red;">${mensagem}</div>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Coleta</th>
                    <th>Local</th>
                    <th>Leitura</th>
                    <th>Unidade</th>
                    <th>Atualização</th>
                    <th>Edição de Leitura</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="leitura" items="${listLeituras}">
                    <tr>
                        <td>${leitura.idLeitura}</td>
                        <td>${leitura.coleta}</td>
                        <td>${leitura.localLeitura}</td>
                        <td>${leitura.leitura}</td>
                        <td>${leitura.unidade}</td>
                        <td>${leitura.atualizacao}</td>
                        <td><a href="editaleitura.html?idLeitura=${leitura.idLeitura}">L</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
