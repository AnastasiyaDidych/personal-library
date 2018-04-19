package com.softserve.personalLibrary.controller.items;

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

@WebServlet(PagePath.ITEM_CREATE)
public class ItemCreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute(Attribute.LOGIN) != null
                & request.getSession().getAttribute(Attribute.ITEM_ID) == null) {

            if (Context.getInstance().getItemService().createItem(request)) {
                response.sendRedirect(PagePath.USER_ITEMS);

            } else {
                request.setAttribute(Attribute.ERROR, "Oops, something went wrong... Try again!");
                request.getRequestDispatcher(JSPPath.ITEM_PROFILE_JSP).forward(request, response);
            }
        } else {
            request.setAttribute(Attribute.ERROR, "You must be logged in!");
            request.getRequestDispatcher(JSPPath.LOGIN_JSP).forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(Attribute.LOGIN) != null
                & request.getSession().getAttribute(Attribute.ITEM_ID) == null) {

            request.getRequestDispatcher(JSPPath.ITEM_PROFILE_JSP).forward(request, response);
        } else {
            request.setAttribute(Attribute.ERROR, "You must be logged in!");
            request.getRequestDispatcher(JSPPath.LOGIN_JSP).forward(request, response);
        }
    }
}

