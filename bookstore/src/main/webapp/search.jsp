<%-- 
    Document   : search
    Created on : 30-mar-2020, 19:44:32
    Author     : nassr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./css-files/search.css">
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
        <form class="form-search" action="search.jsp">
            <input type="text" placeholder="Search..." name="search2">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
