package com.leesee.stockservie.mapper;

import com.leesee.entity.Stock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

@Mapper
public interface StockMapper {



    @Select("select * from stock where warehouse_id =#{id}")
    List<Stock> findStocksByWarehouseId(Long id);


    @Update("update stock set amount=#{amount} where warehouse_id=#{warehouseId} and product_id=#{productId}")
    boolean update(Stock stock);

    @Select("select * from stock where product_id =#{id}")
    List<Stock> findStocksByProductId(Long id);

    @Select("select amount from stock where warehouse_id=#{warehouseId} and product_id=#{productId}")
    Integer findAmount(Stock stock);

    @Insert("insert into stock(warehouse_id,product_id,amount)values (#{warehouseId},#{productId},#{amount})")
    void insert(Stock stock);
}
