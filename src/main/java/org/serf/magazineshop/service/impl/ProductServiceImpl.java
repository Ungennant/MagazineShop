package org.serf.magazineshop.service.impl;

import org.serf.magazineshop.dao.ProductDAO;
import org.serf.magazineshop.dao.impl.ProductDaoImpl;
import org.serf.magazineshop.domain.Product;
import org.serf.magazineshop.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        try {
            this.productDAO = new ProductDaoImpl();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
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
}
