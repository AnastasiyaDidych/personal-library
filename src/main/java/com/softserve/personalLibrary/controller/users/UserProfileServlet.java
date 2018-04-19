package com.softserve.personalLibrary.controller.users;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.constant.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PagePath.USER_PROFILE)
public class UserProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute(Attribute.LOGIN) == null) {

            request.getRequestDispatcher(PagePath.USER_CREATE).forward(request, response);

        } else if (request.getSession().getAttribute(Attribute.LOGIN).toString() != null) {

            request.getRequestDispatcher(PagePath.USER_EDIT).forward(request, response);
        }
    }
}
