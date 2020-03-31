/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.bookstore.controller.commands;

import es.ulpgc.bookstore.controller.data.User;
import es.ulpgc.bookstore.controller.data.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nassr
 */
public class LoginCommand extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            User user = Users.isUserExist(username, password);
            if (user != null) {
                request.setAttribute("loginFailed", false);
                session.setAttribute("User", user);
            } else {
                request.setAttribute("loginFailed", true);
                forward("login");
            }
        } catch ( Exception e) {
            System.out.println(e);
        }
        forward("index");
    }
}
