package com.softserve.personalLibrary.controller.commons;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.constant.JSPPath;
import com.softserve.personalLibrary.constant.PagePath;
import com.softserve.personalLibrary.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({PagePath.ROOT,PagePath.LOGIN})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;
        if ((request.getParameter(Attribute.LOGIN) != null)
                && (!request.getParameter(Attribute.LOGIN).isEmpty())
                && (request.getParameter(Attribute.PASSWORD) != null)
                && (!request.getParameter(Attribute.PASSWORD).isEmpty())) {

            result = Context.getInstance().getUserService().isLogged(request);
        }
        if (result) {
            request.setAttribute(Attribute.LOGIN, request.getParameter(Attribute.LOGIN));
            request.getSession(true).setAttribute(Attribute.LOGIN, request.getParameter(Attribute.LOGIN));

            response.sendRedirect(PagePath.USER_ITEMS);

        } else {
            request.setAttribute(Attribute.ERROR, "Invalid login or password. Try again!");
            request.getRequestDispatcher(JSPPath.LOGIN_JSP).forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JSPPath.LOGIN_JSP).forward(request, response);
    }

}