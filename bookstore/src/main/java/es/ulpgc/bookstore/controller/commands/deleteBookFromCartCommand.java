/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.bookstore.controller.commands;

import es.ulpgc.bookstore.controller.data.Book;
import es.ulpgc.bookstore.controller.data.Books;
import es.ulpgc.bookstore.controller.data.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nassr
 */
public class deleteBookFromCartCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        ((User) session.getAttribute("User")).deleteBookFromCartById(id);

        String[] bookIds = ((User) session.getAttribute("User")).getCart();

        ArrayList<Book> books = new ArrayList<>();

        for (String bookId : bookIds) {
            books.add(Books.getBookById(bookId));
        }
        session.setAttribute("Cart", books);
        forward("cart");
    }

}
