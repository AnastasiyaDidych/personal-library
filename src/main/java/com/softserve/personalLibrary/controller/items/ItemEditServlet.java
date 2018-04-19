package com.softserve.personalLibrary.controller.items;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.constant.JSPPath;
import com.softserve.personalLibrary.constant.PagePath;
import com.softserve.personalLibrary.entity.ItemEntity;
import com.softserve.personalLibrary.util.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PagePath.ITEM_EDIT)
public class ItemEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {

            if (Context.getInstance().getItemService().updateItem(request)) {
                request.getSession().removeAttribute(Attribute.ITEM_ID);
                request.getSession().removeAttribute(Attribute.ITEM);
                response.sendRedirect(PagePath.USER_ITEMS);

            } else {
                request.setAttribute(Attribute.ERROR, "Oops, something went wrong... Try again!");
                request.getRequestDispatcher(JSPPath.ITEM_PROFILE_JSP).forward(request, response);
            }
        } else {
            request.setAttribute(Attribute.ERROR, "You must be logged in!");
            request.getRequestDispatcher(PagePath.LOGIN).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {

            request.getSession().setAttribute(Attribute.ITEM_ID, request.getParameter(Attribute.ID_RQ));
            ItemEntity item = Context.getInstance().getItemService().getItem(request);

            if (item != null) {
                request.getSession().setAttribute(Attribute.ITEM, item);
                request.getRequestDispatcher(JSPPath.ITEM_PROFILE_JSP).forward(request,response);

            } else {
                request.getRequestDispatcher(JSPPath.ITEM_PROFILE_JSP).forward(request, response);
            }

        } else {
            request.setAttribute(Attribute.ERROR, "You must be logged in!");
            request.getRequestDispatcher(PagePath.LOGIN).forward(request, response);
        }
    }
}



