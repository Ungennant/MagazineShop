package org.serf.magazineshop.service;

import org.serf.magazineshop.domain.Product;
import org.serf.magazineshop.shared.AbstractCRUD;

import java.util.Map;

public interface ProductService extends AbstractCRUD<Product> {
    public Map<Integer, Product> readAllMap();
}
