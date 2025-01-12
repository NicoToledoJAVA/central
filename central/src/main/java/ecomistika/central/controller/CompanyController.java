/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.model.Company;
import ecomistika.central.model.Customer;
import ecomistika.central.service.ICompanyService;
import ecomistika.central.service.ICustomerService;
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
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private ICompanyService companyServ;

    @GetMapping("")
    public List<Company> getAllCompanies() {
        return companyServ.getAllCompanies();
    }

    @GetMapping("/get/{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id) {
        return companyServ.getCompanyById(id);
    }

    @PostMapping("/create")
    public Company createCompany(@RequestBody Company company) {
        return companyServ.createCompany(company);
    }

    @PutMapping("/modify")
    public Company updateCompany(@RequestBody Company company) {
        return companyServ.updateCompany(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyServ.deleteCompany(id);
    }
    
}
