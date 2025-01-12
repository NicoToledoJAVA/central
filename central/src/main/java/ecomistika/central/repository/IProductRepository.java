
package ecomistika.central.repository;
import ecomistika.central.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    public Product findByCodeBar(String codeBar);
 

    public List<Product> findByNameContaining(String name);

     
     
     
}




