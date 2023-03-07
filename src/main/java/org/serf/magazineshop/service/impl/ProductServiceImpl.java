package org.serf.magazineshop.service.impl;

import org.apache.log4j.Logger;
import org.serf.magazineshop.dao.ProductDAO;
import org.serf.magazineshop.dao.impl.ProductDaoImpl;
import org.serf.magazineshop.domain.Product;
import org.serf.magazineshop.service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
    private static ProductService productServiceImpl;
    private ProductDAO productDAO;

    private ProductServiceImpl() {
        try {
            productDAO = new ProductDaoImpl();
        } catch (SQLException | ClassNotFoundException throwables) {
            LOGGER.error(throwables);
        }
    }

    public static ProductService getProductService() {
        if (productServiceImpl == null)
            productServiceImpl = new ProductServiceImpl();
        return productServiceImpl;
    }

    @Override
    public Product create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public Product read(Integer id) {
        return productDAO.read(id);
    }

    @Override
    public Product update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }

    @Override
    public List<Product> readAll() {
        return productDAO.readAll();
    }

    @Override
    public Map<Integer, Product> readAllMap() {
        return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
    }
}
