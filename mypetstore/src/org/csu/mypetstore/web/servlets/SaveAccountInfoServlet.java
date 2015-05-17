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
public class SaveAccountInfoServlet extends HttpServlet {

    private AccountService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account loginAccount = (Account)session.getAttribute("loginAccount");
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
            loginAccount.setPassword(password);
            loginAccount.setFirstName(firstName);
            loginAccount.setLastName(lastName);
            loginAccount.setEmail(email);
            loginAccount.setPhone(phone);
            loginAccount.setAddress1(addr1);
            loginAccount.setAddress2(addr2);
            loginAccount.setCity(city);
            loginAccount.setState(state);
            loginAccount.setZip(zip);
            loginAccount.setCountry(country);
            loginAccount.setLanguagePreference(languagePreference);
            loginAccount.setFavouriteCategoryId(favouriteCategoryId);
            loginAccount.setListOption(isListOption);
            loginAccount.setBannerOption(isBannerOption);

            if(service == null){
                service = new AccountService();
            }

            service.updateAccount(loginAccount);

        }
    }
}
