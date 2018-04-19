package com.softserve.personalLibrary.controller.users;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.constant.JSPPath;
import com.softserve.personalLibrary.constant.PagePath;
import com.softserve.personalLibrary.entity.UserEntity;
import com.softserve.personalLibrary.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PagePath.USER_EDIT)
public class UserEditServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter(Attribute.PASSWORD)
                .equals(request.getParameter(Attribute.CONFIRM_PASSWORD))) {
            if (Context.getInstance().getUserService().updateUser(request)) {
                response.sendRedirect(PagePath.USER_ITEMS);
            } else {
                request.setAttribute(Attribute.ERROR, "Oops, something went wrong... Try again!");
                response.sendRedirect(PagePath.USER_ITEMS);
            }
        } else {
            request.setAttribute(Attribute.ERROR, "Oops, something went wrong... Try again!");
            request.getRequestDispatcher(JSPPath.USER_PROFILE_JSP).forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity user = Context.getInstance().getUserService().getUser(request);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher(JSPPath.USER_PROFILE_JSP).forward(request, response);
        } else {
            request.setAttribute(Attribute.ERROR, "Oops, something went wrong... Try again!");
            response.sendRedirect(PagePath.USER_ITEMS);
        }
    }
}
