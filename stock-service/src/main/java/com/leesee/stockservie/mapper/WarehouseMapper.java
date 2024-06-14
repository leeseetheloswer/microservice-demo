package com.leesee.stockservie.mapper;

import com.leesee.entity.Warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    @Select("select * from warehouse")
    List<Warehouse> queryAllWarehouse();

    @Select("select * from warehouse where name like concat('%',#{name},'%')")
    List<Warehouse> findByName(String name);

    @Insert("insert into warehouse(name,address) values (#{name},#{address})")
    void insert(Warehouse warehouse);

    @Delete("delete from warehouse where id=#{id}")
    void delete(int id);


}
