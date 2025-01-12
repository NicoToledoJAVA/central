/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.Stock;
import ecomistika.central.repository.IStockRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {

    @Autowired
    private IStockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Long id, Stock updatedStock) {
        return stockRepository.findById(id)
                .map(stock -> {
                    stock.setProduct(updatedStock.getProduct());
                    stock.setCurrentStock(updatedStock.getCurrentStock());
                    stock.setRestockPoint(updatedStock.getRestockPoint());
                    stock.setLowStockWarningStatus(updatedStock.getLowStockWarningStatus());
                    stock.setLowStockWarningQuantity(updatedStock.getLowStockWarningQuantity());
                    stock.setDesiredStockLevel(updatedStock.getDesiredStockLevel());
                    return stockRepository.save(stock);
                })
                .orElse(null);
    }

    @Override
    public void deleteStock(Long id) {
       stockRepository.deleteById(id);
    }
}
 

