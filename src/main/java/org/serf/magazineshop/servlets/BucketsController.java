package org.serf.magazineshop.servlets;

import com.google.gson.Gson;
import org.serf.magazineshop.domain.Bucket;
import org.serf.magazineshop.domain.Product;
import org.serf.magazineshop.dto.BucketDto;
import org.serf.magazineshop.service.BucketService;
import org.serf.magazineshop.service.ProductService;
import org.serf.magazineshop.service.impl.BucketServiceImpl;
import org.serf.magazineshop.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "BucketsController", value = "/BucketsController")
public class BucketsController extends HttpServlet {

    private BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bucket> buckets = bucketService.readAll();
        Map<Integer, Product> idToProduct = productService.readAllMap();
        List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);

        String json = new Gson().toJson(listOfBucketDtos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private List<BucketDto> map(List<Bucket> buckets, Map<Integer, Product> idToProduct) {
        return	buckets.stream().map(bucket->{
            BucketDto bucketDto = new BucketDto();
            bucketDto.bucketId = bucket.getId();
            bucketDto.purchaseDate = bucket.getPurchaseDate();

            Product product = idToProduct.get(bucket.getProductId());
            bucketDto.name = product.getName();
            bucketDto.description = product.getDescription();
            bucketDto.price = product.getPrice();

            return bucketDto;
        }).collect(Collectors.toList());
    }
}
