
package ecomistika.central.controller;

import ecomistika.central.model.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import ecomistika.central.service.ISaleService;


@RestController
@RequestMapping("/sales")
public class SalesController {
      @Autowired
    private ISaleService saleService;

    @GetMapping("")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public Optional<Sale> getSaleById(@PathVariable Long id) {
        return saleService.getSaleById(id);
    }

     @PostMapping("/doSale")
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    @PutMapping("/modify")
    public Sale updateSale(@RequestBody Sale sale) {
        Long id = sale.getId();
        return saleService.updateSale(id, sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
    }

}
