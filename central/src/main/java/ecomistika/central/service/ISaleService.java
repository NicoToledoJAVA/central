
package ecomistika.central.service;

import ecomistika.central.model.Sale;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


public interface ISaleService {
    
   
    
    public List<Sale> getAllSales(); 

    public Optional<Sale> getSaleById(Long id);

    public Sale createSale(Sale sale);

    public Sale updateSale(Long id, Sale updatedSale);

    public void deleteSale(Long id);

    
}