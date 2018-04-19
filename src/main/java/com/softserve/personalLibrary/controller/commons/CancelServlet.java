package com.softserve.personalLibrary.controller.commons;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.constant.JSPPath;
import com.softserve.personalLibrary.constant.PagePath;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PagePath.CANCEL)
public class CancelServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {
            response.sendRedirect(PagePath.USER_ITEMS);
        }else{
            response.sendRedirect(PagePath.LOGIN);
        }
    }
}
