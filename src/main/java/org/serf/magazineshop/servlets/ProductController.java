package org.serf.magazineshop.servlets;

import org.serf.magazineshop.domain.Product;
import org.serf.magazineshop.service.ProductService;
import org.serf.magazineshop.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {

    ProductService productService = ProductServiceImpl.getProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");

        Product product = productService.read(Integer.parseInt(productId));

        request.setAttribute("product", product);
        request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        Product product = new Product(name, description, getValidatedPrice(price));
        productService.create(product);
        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    private double getValidatedPrice(String price) {
        if (price == null || price.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(price);
    }
}
