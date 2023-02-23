package org.serf.magazineshop.service.impl;

import org.apache.log4j.Logger;
import org.serf.magazineshop.dao.BucketDAO;
import org.serf.magazineshop.dao.impl.BucketDaoImpl;
import org.serf.magazineshop.domain.Bucket;
import org.serf.magazineshop.service.BucketService;

import java.sql.SQLException;
import java.util.List;

public class BucketServiceImpl implements BucketService {

    private static final Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
    private static BucketService bucketServiceImpl;
    private BucketDAO bucketDAO;

    private BucketServiceImpl() {
        try {
            bucketDAO = new BucketDaoImpl();
        } catch (SQLException | ClassNotFoundException throwables) {
            LOGGER.error(throwables);
        }
    }

    public static BucketService getBucketService() {
        if (bucketServiceImpl == null)
            bucketServiceImpl = new BucketServiceImpl();
        return bucketServiceImpl;
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

