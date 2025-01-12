
package ecomistika.central.service;

import ecomistika.central.model.Sale;
import ecomistika.central.model.SaleItem;
import java.util.List;
import java.util.Optional;


public interface ISaleItemService {
    
     public List<SaleItem> getAllSaleItems(); 

    public Optional<SaleItem> getSaleItemById(Long id);

    public SaleItem createSaleItem(SaleItem saleItem);

    public SaleItem updateSaleItem(Long id, SaleItem updatedSaleItem);

    public void deleteSaleItem(Long id);
    
}

