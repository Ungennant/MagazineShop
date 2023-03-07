package org.serf.magazineshop.servlets;

import org.serf.magazineshop.domain.Bucket;
import org.serf.magazineshop.service.BucketService;
import org.serf.magazineshop.service.impl.BucketServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "BucketController", value = "/BucketController")
public class BucketController extends HttpServlet {

    private BucketService bucketService = BucketServiceImpl.getBucketService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        HttpSession session = request.getSession();
        Integer userId = (Integer)session.getAttribute("userId");

        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
        bucketService.create(bucket);


        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bucketId = req.getParameter("bucketId");
        bucketService.delete(Integer.parseInt(bucketId));

        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}

