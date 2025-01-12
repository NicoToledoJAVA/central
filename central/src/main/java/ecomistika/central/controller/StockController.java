/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.model.Sale;
import ecomistika.central.model.Stock;
import ecomistika.central.service.ISaleService;
import ecomistika.central.service.IStockService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/stock")
public class StockController {
    
      @Autowired
    private IStockService stockService;

    @GetMapping("")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Optional<Stock> getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

     @PostMapping("/createStockItem")
    public Stock createStockItem(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @PutMapping("/modify")
    public Stock updateStock(@RequestBody Stock stock) {
        Long id = stock.getId();
        return stockService.updateStock(id, stock);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
    
}
