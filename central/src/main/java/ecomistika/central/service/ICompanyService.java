
package ecomistika.central.service;

import ecomistika.central.model.Category;
import ecomistika.central.model.Company;
import java.util.List;
import java.util.Optional;


public interface ICompanyService {
    
        
    public List<Company> getAllCompanies();

    public Optional<Company> getCompanyById(Long id);

    public Company createCompany(Company company);

    public Company updateCompany(Company company);

    public void deleteCompany(Long id);
    
}
