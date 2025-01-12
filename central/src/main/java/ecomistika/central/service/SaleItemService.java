/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.Product;
import ecomistika.central.model.SaleItem;
import ecomistika.central.repository.IProductRepository;
import ecomistika.central.repository.ISaleItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemService implements ISaleItemService {

    @Autowired
    private ISaleItemRepository saleItemRepository;

    @Override
    public List<SaleItem> getAllSaleItems() {
        return saleItemRepository.findAll();
    }

    @Override
    public Optional<SaleItem> getSaleItemById(Long id) {
        return saleItemRepository.findById(id);
    }

    @Override
    public SaleItem createSaleItem(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    @Override
    public SaleItem updateSaleItem(Long id, SaleItem updatedSaleItem) {
        return saleItemRepository.findById(id)
                .map(saleItem -> {
                    saleItem.setName(updatedSaleItem.getName());
                    // Actualizar los demás campos
                    return saleItemRepository.save(saleItem);
                })
                .orElse(null);
    }

    @Override
    public void deleteSaleItem(Long id) {
        saleItemRepository.deleteById(id);
    }

}
