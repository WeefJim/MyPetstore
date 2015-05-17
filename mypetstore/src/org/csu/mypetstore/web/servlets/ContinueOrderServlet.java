package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by jinyejun on 5/14/15.
 */
public class ContinueOrderServlet extends HttpServlet {

    private final static String VIEW_CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private final static String VIEW_SHOPPING_FORM= "/WEB-INF/jsp/order/ShippingForm.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        // 得到登陆账户
        Account loginAccount = (Account)session.getAttribute("loginAccount");

        String cardType = request.getParameter("cardType");
        String creditCard = request.getParameter("creditCard");
        String expiryDate = request.getParameter("expiryDate");
        String billToFirstName = request.getParameter("billToFirstName");
        String billToLastName = request.getParameter("billToLastName");
        String billAddress1 = request.getParameter("billAddress1");
        String billAddress2 = request.getParameter("billAddress2");
        String billCity = request.getParameter("billCity");
        String billState = request.getParameter("billState");
        String billZip = request.getParameter("billZip");
        String billCountry = request.getParameter("billCountry");
        boolean shippingAddressRequired = request.getParameter("shippingAddressRequired") != null;

        Order order = (Order)session.getAttribute("order");
        order.setOrderDate(new java.util.Date());
        order.setCardType(cardType);
        order.setCreditCard(creditCard);
        order.setExpiryDate(expiryDate);
        order.setBillToFirstName(billToFirstName);
        order.setBillToLastName(billToLastName);
        order.setBillAddress1(billAddress1);
        order.setBillAddress2(billAddress2);
        order.setBillCity(billCity);
        order.setBillState(billState);
        order.setBillZip(billZip);
        order.setBillCountry(billCountry);

        order.setShipToFirstName(billToFirstName);
        order.setShipToLastName(billToLastName);
        order.setShipAddress1(billAddress1);
        order.setShipAddress2(billAddress2);
        order.setShipCity(billCity);
        order.setShipState(billState);
        order.setShipZip(billZip);
        order.setShipCountry(billCountry);
        order.setCourier("UPS");
        order.setStatus("P");

        session.setAttribute("order", order);

        if(shippingAddressRequired){
            request.getRequestDispatcher(VIEW_SHOPPING_FORM).forward(request, response);
        }else{
            request.getRequestDispatcher(VIEW_CONFIRM_ORDER).forward(request, response);
        }


    }
}
