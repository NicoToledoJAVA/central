/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.Sale;
import ecomistika.central.model.SaleItem;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import ecomistika.central.repository.ISaleRepository;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale updateSale(Long id, Sale updatedSale) {
        return saleRepository.findById(id)
                .map(sale -> {
                    sale.setSaleItems(updatedSale.getSaleItems());
                    sale.setStatus(updatedSale.getStatus());
                    sale.setTotalAmount(updatedSale.getTotalAmount());
                    return saleRepository.save(sale);
                })
                .orElse(null);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

}
