package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jinyejun on 5/14/15.
 */
public class OrderConfirmServlet extends HttpServlet {

    private final static String VIEW_ORDER_LIST= "/WEB-INF/jsp/order/ViewOrder.jsp";
    private OrderService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request ,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = (Order)session.getAttribute("order");

        if(service == null){
            service = new OrderService();
        }
        service.insertOrder(order);
        request.getRequestDispatcher(VIEW_ORDER_LIST).forward(request, response);
    }
}
