<%@page import="es.ulpgc.bookstore.controller.data.User"%>
<link rel="stylesheet" href="./css-files/nav.css">
<div>
    <ul>
        <li><a class="active" href="index.jsp">Inicio</a></li>
        <li><a href="#contact">Contacto</a></li>
        <li><a href="search.jsp">Buscar</a></li>
        <li><%
            session = request.getSession(false);
            if (session.getAttribute("User") == null) {
                out.println("<a href=\"login.jsp\">Login</a>");
            } else {
                out.println("<form action=\"FrontControllerServlet\">");
                out.println("<input type=\"submit\" value=\"Cerrar sesión\">");
                out.println("<input type=\"hidden\" name=\"command\" value=\"Logout\">");
                out.println("</form>");

                out.println("<form action=\"FrontControllerServlet\">");
                out.println("<input type=\"submit\" value=\"Mi Carrito\">");
                out.println("<input type=\"hidden\" name=\"command\" value=\"ShoppingCart\">");
                out.println("</form>");

                out.println("<a href=\"#profile\">");
                out.println("Bienvenido " + ((User) session.getAttribute("User")).getUsername());
                out.println("</a>");
            }
            %>
        </li>
    </ul>
</div>