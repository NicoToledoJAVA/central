/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.UserPOS;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Nicolas
 */
public interface IUserService {

    public List<UserPOS> getAllUsers();

    public Optional<UserPOS> getUserById(Long id);
    
    public Optional<UserPOS> getUserByName(String name);

    public UserPOS createUser(UserPOS tax);

    public UserPOS LimitedUpdateUser(Long id, UserPOS updatedUser);

    public UserPOS SecuredUpdateUser(Long id, UserPOS updatedUser);

    public void deleteUser(Long id);
    
      //Método de encriptado
    
     public String encryptPassword(String password);
}
