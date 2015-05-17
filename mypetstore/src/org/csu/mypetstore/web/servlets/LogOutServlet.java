package org.csu.mypetstore.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jinyejun on 5/11/15.
 */
public class LogOutServlet extends HttpServlet {

    private final static String VIEW_MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", false);
        session.setAttribute("isFailed", false);
        session.setAttribute("loginAccount", null);

        request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
    }
}
