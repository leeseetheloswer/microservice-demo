package com.leesee.stockservie.controller;

import com.leesee.entity.Warehouse;
import com.leesee.stockservie.mapper.WarehouseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
@Slf4j
public class WarehouseController {
    @Autowired
    private WarehouseMapper warehouseMapper;
    @GetMapping("/queryAllWarehouses")
    public List<Warehouse> queryAllWarehouse(){
        List<Warehouse> warehouses = warehouseMapper.queryAllWarehouse();
        log.info("-------------OK queryAllWarehouse--------------------");
        return warehouses;

    }

    @PostMapping("/create")
    public boolean createWarehouse(@RequestBody Warehouse warehouse){


        List<Warehouse> warehouses=warehouseMapper.findByName(warehouse.getName());
        for (Warehouse w : warehouses) {
            if(w.getName().equals(warehouse.getName())){
                return false;
            }
        }
        warehouseMapper.insert(warehouse);
        return true;

    }

    @GetMapping("/findByName/{name}")
    public List<Warehouse> findByWarehouseName(@PathVariable String name){
        return  warehouseMapper.findByName(name);
    }




    @DeleteMapping("/delete/{id}")
    public void deleteWarehouse(@PathVariable int id){
        warehouseMapper.delete(id);
    }


}
