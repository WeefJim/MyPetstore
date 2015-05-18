package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by jinyejun on 5/17/15.
 */
public class GetAllProductsServlet extends HttpServlet {

    private CatalogService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(service == null){
            service = new CatalogService();
        }

        List<Product> productList = service.getAllProducts();

        PrintWriter out = response.getWriter();
        response.setContentType("text/xml");
        String productsName = "<names>";
        for(int i=0;i<productList.size();i++){
            productsName += "<name>"+productList.get(i).getName()+"</name>";
        }
        productsName += "</names>";
        out.print(productsName);
        out.flush();
        out.close();

    }
}
