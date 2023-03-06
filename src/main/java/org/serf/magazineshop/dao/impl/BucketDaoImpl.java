package org.serf.magazineshop.dao.impl;

import org.apache.log4j.Logger;
import org.serf.magazineshop.dao.BucketDAO;
import org.serf.magazineshop.domain.Bucket;
import org.serf.magazineshop.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BucketDaoImpl implements BucketDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketDaoImpl() throws SQLException, ClassNotFoundException {
        connection = ConnectionUtils.openConnection();
    }

    private static final String READ_ALL = "SELECT * FROM bucket";
    private static final String CREATE = "INSERT INTO bucket(users_id, products_id, purchase_date) values (?,?,?)";
    private static final String READ_BY_ID = "SELECT * from bucket WHERE id =?";
    private static final String DELETE_BY_ID = "DELETE FROM bucket WHERE id =?";

    private static final Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);

    @Override
    public Bucket create(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            bucket.setId(rs.getInt(1));
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Integer bucketID = result.getInt("id");
            Integer userID = result.getInt("users_id");
            Integer productId = result.getInt("products_id");
            java.util.Date purchaseDate = result.getDate("purchase_date");

            bucket = new Bucket(bucketID, userID, productId, purchaseDate);

        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
        return bucket;
    }

    @Override
    public Bucket update(Bucket bucket) {
        throw new IllegalStateException("There is no available update for bucket table");
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
    }

    @Override
    public List<Bucket> readAll() {
        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer bucketId = result.getInt("id");
                Integer userId = result.getInt("users_id");
                Integer productId = result.getInt("products_id");
                java.util.Date purchaseDate = result.getDate("purchase_date");

                bucketRecords.add(new Bucket(bucketId, userId, productId, purchaseDate));
            }
        } catch (SQLException throwables) {
            LOGGER.error(throwables);
        }
        return bucketRecords;
    }
}
