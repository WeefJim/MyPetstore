package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jinyejun on 5/11/15.
 */
public class AccountLoginServlet extends HttpServlet {


    private final static String VIEW_MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private final static String VIEW_LOGIN = "/WEB-INF/jsp/account/SignonForm.jsp";

    private AccountService service;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        service = new AccountService();
        Account loginAccount = service.getAccount(username, password);
        if(loginAccount != null){
            session.setAttribute("loginAccount", loginAccount);
            request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
        }else{
            request.setAttribute("loginMsg", "Invalid username or password.  Signon failed.");
            request.getRequestDispatcher(VIEW_LOGIN).forward(request,response);
        }

    }
}
