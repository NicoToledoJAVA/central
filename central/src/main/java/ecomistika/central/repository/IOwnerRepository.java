
package ecomistika.central.repository;


import ecomistika.central.model.Owner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long>  {
    //Crea la sentencia en base al nombre en inglés del método
    //Tmb se puede hacer mediante Query pero en este caso no es necesario
    Optional<Owner> findOwnerEntityByNickName(String name);
}

