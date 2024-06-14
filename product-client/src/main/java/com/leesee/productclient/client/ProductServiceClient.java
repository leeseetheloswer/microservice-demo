package com.leesee.productclient.client;


import com.leesee.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品服务远程调用客户端
 */

@FeignClient(name="product-service")
public interface ProductServiceClient {
    @GetMapping("/findByProductId/{productId}")
    Product findByProductId(@RequestParam(value = "productId") Long productId);

    @GetMapping("/findByProductName/{name}")
    List<Product> findByProductName(@RequestParam(value="name") String name);

    @GetMapping("/queryAllProduct")
    List<Product> queryAllProduct();
    @GetMapping("/queryAll")
    List<Product> queryAll();


    @PostMapping("/create")
    void create(Product product);

    @DeleteMapping("/delete/{id}")
    void delete(@RequestParam(value = "id") Long id);

    @PutMapping("/update")
    void update(Product product);


}
