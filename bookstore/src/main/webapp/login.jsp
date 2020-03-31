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
        <link rel="stylesheet" href="./css-files/login.css">
        <script src="./js-files/loginAnimation.js"></script>
    </head>

    <body>

        <%
            if (request.getAttribute("loginFailed") != null) {
                out.println("<div class=\"login-failed\">Usuario o contraseñas incorrectos, vuelva a introducirlos correctamente.</div>");
            }
        %>

        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form>
                    <h1>Crea tu cuenta</h1>
                    <input type="text" placeholder="Usuario" name="username"/>
                    <input type="email" placeholder="Email" name="email"/>
                    <input type="password" placeholder="Contraseña" name="password"/>
                    <button>Registrarse</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form autocomplete="off" action="FrontControllerServlet"  method="post">
                    <h1>Book Store</h1>
                    <input type="text" placeholder="Usuario" name="username"/>
                    <input type="password" placeholder="Contraseña" name="password"/>
                    <input type="hidden" name="command" value="Login">
                    <a href="#">¿Has olvidado tu contraseña?</a>
                    <button>Iniciar sesión</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>¡Bienvenido de nuevo!</h1>
                        <p>Para ver ahora mismo los nuevos libros puedes iniciar sesión ya mismo.</p>
                        <button class="ghost" id="signIn">Iniciar sesión</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>¿Eres un nuevo lector?</h1>
                        <p>No te pierdas la oportunidad de ver nuestro catálogo.</p>
                        <button class="ghost" id="signUp">Registrarse</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
