package ecomistika.central.service;

import ecomistika.central.model.Owner;
import ecomistika.central.model.UserPOS;
import ecomistika.central.repository.IOwnerRepository;
import ecomistika.central.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private IUserRepository userRepo;
    
     @Autowired
    private IOwnerRepository ownerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //tenemos User sec y necesitamos devolver UserDetails
        //traemos el usuario de la bd
        Owner owner = ownerRepo.findOwnerEntityByNickName(username)
        .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no fue encontrado"));
       /* UserPOS userSec = userRepo.findUserEntityByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no fue encontrado"));
*/
        //con GrantedAuthority Spring Security maneja permisos
        List<SimpleGrantedAuthority> authorityList = owner.getAuthorities().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getAuthority()))
                .collect(Collectors.toList());

        /*
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        //Programación funcional a full
        //tomamos roles y los convertimos en SimpleGrantedAuthority para poder agregarlos a la authorityList
        userSec.getAuthorities()
                .forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getAuthority()))));
         */
        //retornamos el usuario en formato Spring Security con los datos de nuestro userSec
        
        
        
        
        return new User(owner.getUsername(),
                owner.getPassword(),
                owner.isEnabled(),
                owner.isAccountNonExpired(),
                owner.isCredentialsNonExpired(),
                owner.isAccountNonLocked(),
                authorityList);
    }

}
