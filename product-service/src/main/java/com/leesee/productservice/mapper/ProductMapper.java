package com.leesee.productservice.mapper;

import com.leesee.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Select("select * from  product p where id= #{productId}")
    Product findByProductId(@Param("productId") Long productId);

    @Select("select *  from product p")
    List<Product> queryAllProduct();

    @Select("select * from product where product_name like concat('%',#{name},'%')")
    List<Product> findByProductName(String name);

    @Delete("delete from product where id= #{id}")
    void delete(Long id);

    @Insert("insert into product(product_name,price) values (#{productName},#{price})")
    void create(Product product);

    @Update("update product set product_name=#{productName},price=#{price} where id=#{id}")
    void update(Product product);
}
