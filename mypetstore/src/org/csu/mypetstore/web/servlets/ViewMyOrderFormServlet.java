package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinyejun on 5/13/15.
 */
public class ViewMyOrderFormServlet extends HttpServlet {

    private final static String VIEW_LOGIN = "/WEB-INF/jsp/account/SignonForm.jsp";
    private final static String VIEW_MY_ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 判断用户是否登陆
        HttpSession session = request.getSession();
        Account loginAccount = (Account)session.getAttribute("loginAccount");
        if(loginAccount == null){
            request.setAttribute("loginMsg", "You must sign on before attempting to check out. Please sign on and try checking out again." );
            request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
        }else{
            // 把购物车的东西放到order里面
            List<CartItem> itemList = ((Cart)session.getAttribute("cart")).getCartItemList();
            List<LineItem> lineItemList = new ArrayList<LineItem>();
            Order order = new Order();
            BigDecimal totalPrice = new BigDecimal(0);
            for(int i=0;i<itemList.size();i++){
                CartItem cartItem = itemList.get(i);
                LineItem lineItem = new LineItem();
                lineItem.setItem(cartItem.getItem());
                lineItem.setQuantity(cartItem.getQuantity());
                lineItem.setItemId(cartItem.getItem().getItemId());
                lineItem.setUnitPrice(cartItem.getItem().getUnitCost());
                lineItem.setLineNumber(i + 1);
                lineItemList.add(lineItem);
                totalPrice = totalPrice.add(cartItem.getTotal());
            }
            order.setTotalPrice(totalPrice);
            order.setLineItems(lineItemList);
            session.setAttribute("order", order);
            request.getRequestDispatcher(VIEW_MY_ORDER).forward(request, response);
        }


    }
}
