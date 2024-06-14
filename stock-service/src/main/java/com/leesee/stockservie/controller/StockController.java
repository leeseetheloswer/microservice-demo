package com.leesee.stockservie.controller;


import com.leesee.entity.Stock;
import com.leesee.stockservie.mapper.StockMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {
    @Autowired
    private StockMapper stockMapper;





    @GetMapping("/findByProductId/{id}")
    public List<Stock> findStocksByProductId(@PathVariable Long id){
        List<Stock> stocks=stockMapper.findStocksByProductId(id);
        log.info("-------------OK findByProductId--------------------");
        return stocks;
    }

    @GetMapping("/findByWarehouseId/{id}")
    public List<Stock> findStocksByWarehouseId(@PathVariable Long id){
        List<Stock>stocks=stockMapper.findStocksByWarehouseId(id);
        log.info("-------------OK findByWarehouseId--------------------");
       return stocks;
    }


    @PostMapping("/insert")
    public void insert(@RequestBody Stock stock){
        log.info("-------------insert--------------------");
        stockMapper.insert(stock);
        log.info("service接收到插入请求：{}",stock);

    }
    @PutMapping("/update")
    public void update(@RequestBody Stock stock){
        log.info("-------------update--------------------");
        stockMapper.update(stock);
        log.info("service接收到更新请求：{}",stock);

    }

    @PostMapping("/findAmount")
    public int findAmount(@RequestBody Stock stock){
        log.info("-------------findAmount:WarehouseId is {},ProductId is {}--------------------",stock.getWarehouseId(),stock.getProductId());
       Integer res= stockMapper.findAmount(stock);
       if(res==null){
           return 0;
       }
       return res;
    }



}
