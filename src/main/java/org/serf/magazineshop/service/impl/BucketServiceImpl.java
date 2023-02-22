package org.serf.magazineshop.service.impl;

import org.serf.magazineshop.dao.BucketDAO;
import org.serf.magazineshop.dao.impl.BucketDaoImpl;
import org.serf.magazineshop.domain.Bucket;
import org.serf.magazineshop.service.BucketService;

import java.sql.SQLException;
import java.util.List;

public class BucketServiceImpl implements BucketService {

    private BucketDAO bucketDAO;

    public BucketServiceImpl(BucketDAO bucketDAO) {
        try {
            this.bucketDAO = new BucketDaoImpl();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Bucket create(Bucket bucket) {
        return bucketDAO.create(bucket);
    }

    @Override
    public Bucket read(Integer id) {
       return bucketDAO.read(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDAO.update(bucket);
    }

    @Override
    public void delete(Integer id) {
        bucketDAO.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDAO.readAll();
    }
}

