package org.csu.mypetstore.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jinyejun on 5/11/15.
 */
public class ViewNewAccountServlet extends HttpServlet {

    private final static String VIEW_NEW_ACCOUNT = "/WEB-INF/jsp/account/NewAccountForm.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VIEW_NEW_ACCOUNT).forward(request,response);
    }
}
