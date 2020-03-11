/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.bookstore.controller;

import es.ulpgc.bookstore.controller.commands.FrontCommand;
import es.ulpgc.bookstore.controller.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author nassr
 */
public class FrontControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();

    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(
                    String.format(
                            "es.ulpgc.bookstore.controller.commands.%sCommand",
                            request.getParameter("command")
                    )
            );
            return (FrontCommand) type
                    .asSubclass(FrontCommand.class)
                    .newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            return new UnknownCommand();
        }
    }
}
