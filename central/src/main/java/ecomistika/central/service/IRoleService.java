package ecomistika.central.service;

import ecomistika.central.model.auth.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
    Role update(Role role);
}
