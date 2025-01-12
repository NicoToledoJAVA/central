
package ecomistika.central.service;


import ecomistika.central.model.Stock;
import java.util.List;
import java.util.Optional;


public interface IStockService {

    public List<Stock> getAllStocks();

    public Optional<Stock> getStockById(Long id);

    public Stock createStock(Stock stock);

    public Stock updateStock(Long id, Stock updatedStock);

    public void deleteStock(Long id);

}
