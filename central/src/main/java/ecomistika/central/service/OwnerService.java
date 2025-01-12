/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.Owner;

import ecomistika.central.repository.IOwnerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService {

    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Optional<Owner> getOwnerByNickName(String name) {

        return ownerRepository.findOwnerEntityByNickName(name);
    }

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    
      //agregamos el método encript password en OwnerService
    @Override
    public String encryptPassword(String password) {
       return new BCryptPasswordEncoder().encode(password);
    }

}
