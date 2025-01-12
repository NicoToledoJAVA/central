package ecomistika.central.controller;

import ecomistika.central.model.SaleItem;
import ecomistika.central.service.ISaleItemService;
import ecomistika.central.service.ISaleService;
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
@RequestMapping("/saleItems")
public class SaleItemController {

    @Autowired
    private ISaleItemService saleItemServ;

    @GetMapping("")
    public List<SaleItem> getAllSaleItems() {
        return saleItemServ.getAllSaleItems();
    }

    @GetMapping("/{id}")
    public Optional<SaleItem> getSaleItemById(@PathVariable Long id) {
        return saleItemServ.getSaleItemById(id);
    }

    @PostMapping("/create")
    public SaleItem createSaleItem(@RequestBody SaleItem saleItem) {
        return saleItemServ.createSaleItem(saleItem);
    }

    @PutMapping("/modify")
    public SaleItem updateSaleItem(@RequestBody SaleItem saleItem) {
        Long id = saleItem.getId();
        return saleItemServ.updateSaleItem(id, saleItem);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSaleItem(@PathVariable Long id) {
        saleItemServ.deleteSaleItem(id);
    }

}
