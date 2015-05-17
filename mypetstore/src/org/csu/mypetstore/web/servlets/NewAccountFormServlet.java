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
public class NewAccountFormServlet extends HttpServlet {

    private final static String VIEW_RESULT = "/WEB-INF/jsp/common/Error.jsp";

    private AccountService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = new Account();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeatedPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String addr1 = request.getParameter("address1");
        String addr2 = request.getParameter("address2");
        String city = request.getParameter("city");
        String state = request.getParameter("city");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        String languagePreference = request.getParameter("languagePreference");
        String favouriteCategoryId = request.getParameter("favouriteCategoryId");
        boolean isListOption = request.getParameter("isListOption") == "on";
        boolean isBannerOption = request.getParameter("isBannerOption") == "on";

        if(password.equals(repeatedPassword)){
            account.setUsername(username);
            account.setPassword(password);
            account.setFirstName(firstName);
            account.setLastName(lastName);
            account.setEmail(email);
            account.setPhone(phone);
            account.setAddress1(addr1);
            account.setAddress2(addr2);
            account.setCity(city);
            account.setState(state);
            account.setZip(zip);
            account.setStatus("OK");
            account.setCountry(country);
            account.setLanguagePreference(languagePreference);
            account.setFavouriteCategoryId(favouriteCategoryId);
            account.setListOption(isListOption);
            account.setBannerOption(isBannerOption);

            if(service == null){
                service = new AccountService();
            }

            service.insertAccount(account);

            session.setAttribute("message", "Register Success!");
            request.getRequestDispatcher(VIEW_RESULT).forward(request, response);

        }
    }
}
