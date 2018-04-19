package com.softserve.personalLibrary.controller.items;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.constant.JSPPath;
import com.softserve.personalLibrary.constant.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/itemProfile")
public class ItemProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {
            if (request.getSession().getAttribute(Attribute.ITEM_ID) == null) {
                request.getRequestDispatcher(PagePath.ITEM_CREATE).forward(request, response);

            } else if (Long.parseLong(request.getSession().getAttribute(Attribute.ITEM_ID).toString()) > 0) {

                request.setAttribute(Attribute.ITEM_ID, request.getParameter(Attribute.ID_RQ));
                request.getRequestDispatcher(PagePath.ITEM_EDIT).forward(request, response);

            } else {
                request.setAttribute(Attribute.ERROR, "You must be logged in!");
                request.getRequestDispatcher(JSPPath.LOGIN_JSP).forward(request, response);
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(JSPPath.ITEM_PROFILE_JSP).forward(request, response);
    }
}




