package com.leesee.productservice.controller;


import com.leesee.entity.Product;
import com.leesee.productservice.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@Slf4j
public class ProductController {
    private final ProductMapper productMapper;
    /**
     * 根据商品 id 查询商品
     */
    @GetMapping("/findByProductId/{productId}")
    public Product findByProductId(@PathVariable Long productId) {
        Product product = productMapper.findByProductId(productId);
        log.info("-------------OK /findByProductId/{productId}--------------------");
        return product;
    }

    /**
     * 根据名称查询商品
     * @param name
     * @return
     */
    @GetMapping("/findByProductName/{name}")
    public List<Product> findByProductName(@PathVariable String name) {
        List<Product> products = productMapper.findByProductName(name);
        log.info("-------------OK /findByProductName/{name}--------------------");
        return products;
    }

    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllProduct")
    public List<Product> queryAllProduct() throws InterruptedException {
        List<Product> productList = productMapper.queryAllProduct();
//        Thread.sleep(5000);
        log.info("-------------OK queryAllProduct--------------------");
        return productList;
    }

    @PostMapping("/create")
    public void create(@RequestBody Product product){
        productMapper.create(product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productMapper.delete(id);
        log.info("-------------OK delete:{}--------------------",id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Product product){
        productMapper.update(product);
        log.info("-------------OK update:{}--------------------",product);
    }

}
