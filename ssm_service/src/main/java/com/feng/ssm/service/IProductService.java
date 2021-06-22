package com.feng.ssm.service;

import com.feng.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {

    public List<Product> findAll(int page, int size) throws Exception;

    void save(Product product);
}
