<%-- 
    Document   : login
    Created on : 10-mar-2020, 11:06:19
    Author     : nassr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
    </head>
    <body>
        <div>
            <form action="FrontControllerServlet"  method="post">  
                Username:<input type="text" name="username"/><br/>
                Password:<input type="password" name="password"/><br/>
                <input type="hidden" name="command" value="Login">
                <input type="submit" value="Iniciar sesión"/>
            </form>
        </div>

    </body>
</html>
