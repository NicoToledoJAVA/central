package ecomistika.central.controller;

import ecomistika.central.dto.LoginRequestDTO;
import ecomistika.central.model.Company;
import ecomistika.central.model.Owner;
import ecomistika.central.model.Sale;
import ecomistika.central.model.UserPOS;
import ecomistika.central.model.auth.Role;
import ecomistika.central.service.ICompanyService;
import ecomistika.central.service.IOwnerService;
import ecomistika.central.service.IRoleService;
import ecomistika.central.service.IUserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class UserPOSController {

    @Autowired
    private IUserService userServ;
    
    @Autowired
    private IOwnerService ownerServ;

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN') and hasAuthority('CREATE')")
    public ResponseEntity createSaler(@RequestBody LoginRequestDTO userProyect, Owner owner) {
        // 1️⃣ Verificar si el usuario ya existe en la base de datos
        Boolean userExists = userServ.getUserByName(userProyect.getUserName()).isPresent();
        Boolean ownerExists = ownerServ.getOwnerByNickName(owner.getNickName()).isPresent();
        if (!ownerExists) {
            throw new IllegalArgumentException("El propietario '" + owner.getNickName() + "' no está registrado en el sistema. El método no procederá.");
        }
        
        if (userExists) {
            throw new IllegalArgumentException("El nombre de usuario '" + userProyect.getUserName() + "' ya está en uso.");
        } else {
            Set<GrantedAuthority> authoritySet = new HashSet();
            GrantedAuthority readRole;
            UserPOS newSaler = new UserPOS();
            newSaler.setUserName(userProyect.getUserName());
            //encriptamos contraseña
            newSaler.setPasswordHash(userServ.encryptPassword(userProyect.getPasswordHash()));

            newSaler.setFirstName("nombre");
            newSaler.setLastName("apellido");
            newSaler.setId_number("vacio");
            newSaler.setEnabled(true);
            newSaler.setAccountNotExpired(true);
            newSaler.setAccountNotLocked(true);
            newSaler.setCredentialNotExpired(false);

            List<Sale> userSalesList = new ArrayList();
            newSaler.setUserSalesList(userSalesList);
            newSaler.setOwner(owner);

            // Recuperar la Permission/s por su ID
            for (GrantedAuthority role
                    : owner.getAuthorities()) {
                readRole = role;
                if (readRole != null) {
                    //si encuentro, guardo en la lista
                    authoritySet.add(readRole);
                }
            }

            if (!authoritySet.isEmpty()) {

                newSaler = userServ.createUser(newSaler);
                return ResponseEntity.ok(newSaler);
            }

            return null;
        }
    }

    @GetMapping("")
    public List<UserPOS> getAllUsers() {
        return userServ.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public Optional<UserPOS> getUserById(@PathVariable Long id) {
        return userServ.getUserById(id);
    }

    @PutMapping("/limitMod")
    public UserPOS updateUser(@RequestBody Long id, UserPOS user) {
        return userServ.LimitedUpdateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServ.deleteUser(id);
    }

    @GetMapping("/holaseg")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String secHelloWorld() {

        return "Hola Mundo TodoCode con seguridad";
    }

    @GetMapping("/holaseg2")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String secHelloWorld2() {
        return "Hola Mundo TodoCode con seguridad";
    }

    @GetMapping("/holanoseg")
    @PreAuthorize("permitAll()")
    public String noSecHelloWorld() {

        return "Hola mundo TodoCode sin seguridad";
    }

}
