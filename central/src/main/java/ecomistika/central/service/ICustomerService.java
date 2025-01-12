package ecomistika.central.service;

import ecomistika.central.model.Customer;

import java.util.List;
import java.util.Optional;


public interface ICustomerService {

    public List<Customer> getAllCustomers();

    public Optional<Customer> getCustomerById(Long id);

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(Long id);
}
