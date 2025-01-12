/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ecomistika.central.repository;


import ecomistika.central.model.UserPOS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserPOS, Long> {
    
    //Crea la sentencia en base al nombre en inglés del método
    //Tmb se puede hacer mediante Query pero en este caso no es necesario
    Optional<UserPOS> findUserEntityByUserName(String username);
    
}




