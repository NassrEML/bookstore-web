<%-- 
    Document   : cart
    Created on : 30-mar-2020, 21:09:03
    Author     : nassr
--%>

<%@page import="java.util.Arrays"%>
<%@page import="es.ulpgc.bookstore.controller.data.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi carrito</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="./css-files/cart.css">
        <script src="./js-files/favouriteQuantity.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <%
            session = request.getSession(false);
            if (session.getAttribute("User") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <div class="shopping-cart">
            <!-- Title -->
            <div class="title">
                Mi carrito :)
            </div>

            <%
                System.out.println("LLEGÓ!!!!!!!!");
                ArrayList<Book> books = (ArrayList)session.getAttribute("Cart");
                System.out.println("LLEGÓ!!!!!!!!");
                System.out.println(Arrays.deepToString(books.toArray()));
                StringBuilder str = new StringBuilder();

                for (Book book : books) {
                    str.append("<div class=\"item\">"
                            + "<div class=\"buttons\">"
                            + "<form action=\"FrontControllerServlet\" method=\"post\">"
                            + "<input type=\"hidden\" name=\"id\" value=\"" + book.getId() + "\">"
                            + "<input type=\"hidden\" name=\"command\" value=\"deleteBookFromCart\">"
                            + "<button type=\"submit\" class=\"delete-btn\"></button>"
                            + "</form>"
                            + "<span class=\"like-btn\"></span>"
                            + "</div>"
                            + "<div class=\"image\">"
                            + "<img src=\"https://static1.abc.es/media/cultura/2019/08/07/libros-0010-kM0E--620x349@abc.jpg\" alt=\"Libro\"/>"
                            + "</div>"
                            + "<div class=\"description\">"
                            + "<span>" + book.getTitle() + "</span>"
                            + "</div>"
                            + "<div class=\"quantity\">"
                            + "<button class=\"plus-btn\" type=\"button\" name=\"button\">"
                            + "<img src=\"./icons/plus.svg\" alt=\"plus\" />"
                            + "</button>"
                            + "<input type=\"text\" name=\"name\" value=\"1\">"
                            + "<button class=\"minus-btn\" type=\"button\" name=\"button\">"
                            + "<img src=\"./icons/minus.svg\" alt=\"minus\" />"
                            + "</button>"
                            + "</div>"
                            + "<div class=\"total-price\">" + book.getPrice() + "/ud. </div>"
                            + "</div>");
                }
                out.println(str.toString());
            %>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>