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

@WebServlet(PagePath.USER_ITEMS)
public class UserItemsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("USER_ITEMS_POST");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {

            String loginReq = (request.getSession().getAttribute(Attribute.LOGIN)).toString();

            request.setAttribute(Attribute.ITEM_LIST, Context.getInstance().getConjointService().fullItemList(loginReq));

            request.getRequestDispatcher(JSPPath.USERITEMS_JSP).forward(request, response);


            // clean my list
            Context.getInstance().getConjointService().fullItemList(loginReq).clear();
        } else {
            request.setAttribute(Attribute.ERROR, "You must be logged in!");
            request.getRequestDispatcher(JSPPath.LOGIN_JSP).forward(request, response);
        }
    }
}
