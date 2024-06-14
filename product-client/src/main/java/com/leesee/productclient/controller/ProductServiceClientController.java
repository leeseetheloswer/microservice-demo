package com.leesee.productclient.controller;

import com.leesee.entity.Product;
import com.leesee.productclient.client.ProductServiceClient;

import com.leesee.util.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@Slf4j
public class ProductServiceClientController {

    @Autowired
    private final ProductServiceClient prodServiceClient;



    /**
     * 根据商品 id 查询商品
     */
    @GetMapping("/findByProductId/{productId}")
    public Result findByProductId(@PathVariable Long productId) {
        Product product = prodServiceClient.findByProductId(productId);
        log.info("-------------In client findByProductId---------------");
        return Result.success(product);
    }
    /**
     * 查询所有商品
     */
    @GetMapping("/queryAllProduct")
    public Result<List<Product>> queryAllProduct() {
        List<Product> productList = prodServiceClient.queryAllProduct();
        log.info("--------------In client queryAllProduct--------------");
        return Result.success(productList);
    }

    @GetMapping("/findByProductName/{name}")
    public Result findByProductName(@PathVariable String name){
        List<Product> productList=prodServiceClient.findByProductName(name);
        log.info("--------------In client findByProductName--------------");
        return Result.success(productList);
    }

    @PostMapping("/create")
    public Result create(@RequestBody Product  product){
           prodServiceClient.create(product);
           log.info("--------------In client create:{}--------------",product);
           return Result.success();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public Result delete(@PathVariable Long id){
        prodServiceClient.delete(id);
        log.info("--------------In client delete id:{}--------------",id);
        return Result.success();
    }

    @PutMapping("/update")
    public  Result update(@RequestBody Product product){
        prodServiceClient.update(product);
        log.info("--------------In client update :{}--------------",product);
        return Result.success();
    }



}
