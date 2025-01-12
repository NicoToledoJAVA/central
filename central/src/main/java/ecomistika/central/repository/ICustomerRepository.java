package ecomistika.central.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecomistika.central.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    
}



