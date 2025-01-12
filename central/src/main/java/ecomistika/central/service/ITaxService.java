/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ecomistika.central.service;


import ecomistika.central.model.Tax;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Nicolas
 */
public interface ITaxService {
    
     public List<Tax> getAllTaxes();

    public Optional<Tax> getTaxById(Long id);

    public Tax createTax(Tax tax);

    public Tax updateTax(Long id, Tax updatedTax);

    public void deleteTax(Long id);
    
}
