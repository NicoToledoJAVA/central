/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.model.Owner;
import ecomistika.central.model.UserPOS;
import ecomistika.central.service.IOwnerService;
import ecomistika.central.service.IUserService;
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
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private IOwnerService ownServ;

    @GetMapping("")
    public List<Owner> getAllOwners() {
        return ownServ.getAllOwners();
    }

    @GetMapping("/get/{id}")
    public Optional<Owner> getOwnerById(@PathVariable Long id) {
        return ownServ.getOwnerById(id);
    }

    @PostMapping("/create")
    public Owner createOwner(@RequestBody Owner owner) {
        return ownServ.createOwner(owner);
    }

    @PutMapping("/modify")
    public Owner updateOwner(@RequestBody Long id, Owner owner) {
        return ownServ.updateOwner(owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownServ.deleteOwner(id);

    }
}
