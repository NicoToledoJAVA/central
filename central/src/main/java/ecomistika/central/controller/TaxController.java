/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.model.Owner;
import ecomistika.central.model.Tax;
import ecomistika.central.service.IOwnerService;
import ecomistika.central.service.ITaxService;
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
@RequestMapping("/taxes")
public class TaxController {
        
    @Autowired
    private ITaxService taxServ;

    @GetMapping("")
    public List<Tax> getAllTaxes() {
        return taxServ.getAllTaxes();
    }

    @GetMapping("/get/{id}")
    public Optional<Tax> getTaxById(@PathVariable Long id) {
        return taxServ.getTaxById(id);
    }

    @PostMapping("/create")
    public Tax createTax(@RequestBody Tax tax) {
        return taxServ.createTax(tax);
    }

    @PutMapping("/modify")
    public Tax updateTax(@RequestBody Long id, Tax tax) {
        return taxServ.updateTax(id, tax);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        taxServ.deleteTax(id);

    }
    
}
