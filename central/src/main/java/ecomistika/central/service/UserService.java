/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.UserPOS;

import ecomistika.central.repository.IUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserPOS> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserPOS> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
      @Override
    public Optional<UserPOS> getUserByName(String name) {
        return userRepository.findUserEntityByUserName(name);
    }

    @Override
    public UserPOS createUser(UserPOS posUser) {
        return userRepository.save(posUser);
    }

    @Override
    public UserPOS LimitedUpdateUser(Long id, UserPOS updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUserName(updatedUser.getUsername());
                    user.setPasswordHash(updatedUser.getPasswordHash());
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @Override
    public UserPOS SecuredUpdateUser(Long id, UserPOS updatedUser) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setUserName(updatedUser.getUsername());
                    user.setPasswordHash(updatedUser.getPasswordHash());
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    user.setId_number(updatedUser.getId_number());
                    user.setEnabled(updatedUser.getEnabled());
                    user.setAccountNotExpired(updatedUser.getAccountNotExpired());
                    user.setAccountNotLocked(updatedUser.getAccountNotLocked());
                    user.setCredentialNotExpired(updatedUser.getCredentialNotExpired());
                    user.setUserSalesList(updatedUser.getUserSalesList());
                    user.setOwner(updatedUser.getOwner());
                    return userRepository.save(user);

                })
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
       //agregamos el método encript password en UserService
    @Override
    public String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
