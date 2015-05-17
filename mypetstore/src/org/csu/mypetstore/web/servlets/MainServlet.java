package org.csu.mypetstore.web.servlets;

import java.io.IOException;

/**
 * Created by jinyejun on 5/10/15.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.getRequestDispatcher(MAIN).forward(request,response);
    }
}
