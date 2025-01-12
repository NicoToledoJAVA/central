
package ecomistika.central.service;

import ecomistika.central.model.Tax;

import ecomistika.central.repository.ITaxRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaxService implements ITaxService {
 @Autowired
    private ITaxRepository taxRepository;
    @Override
    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }

    @Override
    public Optional<Tax> getTaxById(Long id) {
         return taxRepository.findById(id);
    }

    @Override
    public Tax createTax(Tax tax) {
       return taxRepository.save(tax);
    }

    @Override
    public Tax updateTax(Long id, Tax updatedTax) {
return taxRepository.findById(id)
                .map(tax -> {
                    tax.setName(updatedTax.getName());
                    tax.setRate(updatedTax.getRate());
                   
                    return taxRepository.save(tax);
                })
                .orElse(null);       
    }

    @Override
    public void deleteTax(Long id) {
        taxRepository.deleteById(id);
    }
    
}


