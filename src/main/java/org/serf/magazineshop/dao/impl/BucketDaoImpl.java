package org.serf.magazineshop.dao.impl;

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

    private static String READ_ALL = "SELECT * FROM bucket";
    private static String CREATE = "INSERT INTO bucket('user_id', 'product_id', 'purchase_date') values (?,?,?)";
    private static String READ_BY_ID = "SELECT * from bucket WHERE id =?";
    private static String DELETE_BY_ID = "DELETE FROM bucket WHERE id =?";

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
            throwables.printStackTrace();
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
            Integer userID = result.getInt("user_id");
            Integer productId = result.getInt("product_id");
            java.util.Date purchaseDate = result.getDate("purchase_date");

            bucket = new Bucket(bucketID, userID, productId, purchaseDate);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            throwables.printStackTrace();

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
                Integer userId = result.getInt("user_id");
                Integer productId = result.getInt("product_id");
                java.util.Date purchaseDate = result.getDate("purchase_date");

                bucketRecords.add(new Bucket(bucketId, userId, productId, purchaseDate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bucketRecords;
    }
}
