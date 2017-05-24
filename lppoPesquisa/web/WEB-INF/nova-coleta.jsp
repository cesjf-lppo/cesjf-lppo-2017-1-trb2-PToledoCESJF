<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Coleta</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Nova Coleta!</h1>
        <div style="color: red;">${mensagem}</div>
        <form method="POST">
            <div><label>Pedido: <input type="text" name="txtDescricao" placeholder="Descrição da coleta"/></label></div>
            <div><label>Data: <input type="text" name="txtData" placeholder="Data da coleta"/></label></div>
            <div> <input type="submit" /></div>
        </form>
    </body>
</html>
