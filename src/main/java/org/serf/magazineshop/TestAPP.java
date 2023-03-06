package org.serf.magazineshop;

import org.serf.magazineshop.domain.Bucket;
import org.serf.magazineshop.service.BucketService;
import org.serf.magazineshop.service.impl.BucketServiceImpl;

import java.util.Date;

public class TestAPP {

    public static void main(String[] args) {
        BucketService bucketService = BucketServiceImpl.getBucketService();
        Bucket bucket = new Bucket(1, Integer.parseInt("1"), new Date());
        bucketService.create(bucket);
        System.out.println("Item added!");
    }

}
