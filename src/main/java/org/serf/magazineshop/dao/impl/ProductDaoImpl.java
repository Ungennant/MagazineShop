package org.serf.magazineshop.dao.impl;

import org.serf.magazineshop.dao.ProductDAO;
import org.serf.magazineshop.domain.Product;
import org.serf.magazineshop.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public ProductDaoImpl() throws SQLException, ClassNotFoundException {
        connection = ConnectionUtils.openConnection();
    }

    private static String READ_ALL = "SELECT * FROM products";
    private static String CREATE = "INSERT INTO products('name', 'description', 'price') values (?,?,?)";
    private static String READ_BY_ID = "SELECT * from products WHERE id =?";
    private static String UPDATE_BY_ID = "UPDATE products SET name=?, description=?, price=? WHERE id =?";
    private static String DELETE_BY_ID = "DELETE FROM products WHERE id =?";

    @Override
    public Product create(Product product) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            product.setId(rs.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public Product read(Integer id) {
        Product product = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Integer productId = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            Double price = result.getDouble("price");

            product = new Product(productId, name, description, price);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    @Override
    public List<Product> readAll() {
        List<Product> productRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer productId = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Double price = result.getDouble("price");

                productRecords.add(new Product(productId, name, description, price));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productRecords;
    }
}

