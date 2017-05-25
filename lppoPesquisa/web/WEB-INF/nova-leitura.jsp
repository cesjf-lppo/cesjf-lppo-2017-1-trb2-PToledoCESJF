<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Ponto de Leitura</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Novo ponto de Leitura!</h1>
        <div style="color: red;">${mensagem}</div>
        <form method="POST">
            <div><label>Coleta : ${coleta}<input type="hidden" name="txtColeta" value="${coleta}"/></label></div>
            <div><label>Unidade: <input type="text" name="txtUnidade" placeholder="Unidade de leitura"/></label></div>
            <div><label>Local: <input type="text" name="txtLocalLeitura" placeholder="Local de Leitura"/></label></div>
            <div> <input type="submit" /></div>
        </form>
    </body>
</html>
