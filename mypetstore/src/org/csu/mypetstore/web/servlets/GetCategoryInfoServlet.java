package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by jinyejun on 5/15/15.
 */
public class GetCategoryInfoServlet extends HttpServlet {

    private CatalogService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");

        if(service == null){
            service = new CatalogService();
        }

        List<Product> productList = service.getProductListByCategory(category);
        String products = "";
        for(int i=0;i<productList.size();i++){
            products += productList.get(i).getName() + ",";
        }
        System.out.println(products);
        PrintWriter out = response.getWriter();
        out.println(products);
        out.flush();
        out.close();

    }
}
