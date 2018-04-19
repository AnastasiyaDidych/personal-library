package com.softserve.personalLibrary.controller.users;


import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.constant.JSPPath;
import com.softserve.personalLibrary.constant.PagePath;
import com.softserve.personalLibrary.util.Context;
import sun.security.krb5.internal.PAData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PagePath.USER_CREATE)
public class UserCreateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(Attribute.LOGIN);
        if (Context.getInstance().getUserService().checkData(login) &&
                (request.getParameter(Attribute.PASSWORD)
                        .equals(request.getParameter(Attribute.CONFIRM_PASSWORD)))) {
            if (Context.getInstance().getUserService().createUser(request)) {
                response.sendRedirect(PagePath.LOGIN);
            } else {
                request.setAttribute(Attribute.ERROR, "Oops, something went wrong... Try again!");
                request.getRequestDispatcher(JSPPath.USER_PROFILE_JSP).forward(request, response);
            }
        } else {
            request.setAttribute(Attribute.ERROR, "Oops");
            request.getRequestDispatcher(JSPPath.USER_PROFILE_JSP).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        if (request.getSession().getAttribute(Attribute.LOGIN) == null) {
            request.getRequestDispatcher(JSPPath.USER_PROFILE_JSP).forward(request, response);
        } else {
            request.setAttribute(Attribute.ERROR, "Before register a new user, you must log out");
            request.getRequestDispatcher(PagePath.USER_ITEMS).forward(request, response);
        }
    }
}
