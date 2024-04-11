package com.leesee.productclient.client;

import com.leesee.productclient.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品服务远程调用客户端
 */

@FeignClient(name="product-service",fallback = ProductServiceFallback.class)
public interface ProductServiceClient {
    @GetMapping("/findByProductId/{productId}")
    Product findByProductId(@RequestParam(value = "productId") Long productId);

    @GetMapping("queryAllProduct")
    List<Product> queryAllProduct();
    @GetMapping("queryAll")
    List<Product> queryAl();



}
