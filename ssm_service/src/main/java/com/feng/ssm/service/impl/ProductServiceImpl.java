package com.feng.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.feng.ssm.dao.IProductDao;
import com.feng.ssm.domain.Product;
import com.feng.ssm.service.IProductService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        //pageNum是当前页码值，pageSize是每页显示条数
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        product.setId(uuid);
        productDao.save(product);
        /*productDao.save(product);*/
    }
}
