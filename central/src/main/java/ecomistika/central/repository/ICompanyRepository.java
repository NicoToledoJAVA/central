
package ecomistika.central.repository;


import ecomistika.central.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {
    
}

