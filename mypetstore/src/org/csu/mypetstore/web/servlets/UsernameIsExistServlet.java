package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jinyejun on 5/15/15.
 */
public class UsernameIsExistServlet extends HttpServlet {

    private AccountService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        if(service == null){
            service = new AccountService();
        }
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        if(service.getAccount(username) == null){
            out.println("<msg>NotExist</msg>");
        }else{
            out.println("<msg>Exist</msg>");
        }
        out.flush();
        out.close();
    }
}
