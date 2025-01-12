package ecomistika.central.service;


import ecomistika.central.model.Owner;
import java.util.List;
import java.util.Optional;

public interface IOwnerService {

    public List<Owner> getAllOwners();

    public Optional<Owner> getOwnerById(Long id);
    
     public Optional<Owner> getOwnerByNickName(String name);

    public Owner createOwner(Owner owner);

    public Owner updateOwner(Owner owner);

    public void deleteOwner(Long id);
    
     //Método de encriptado
    
     public String encryptPassword(String password);

}
