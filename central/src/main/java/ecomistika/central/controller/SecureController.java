/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @GetMapping("/info")
    public String secureInfo() {
        return "Esta es información segura. Acceso autorizado.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/info")
    public String adminInfo() {
        return "Esta es información segura para administradores. Acceso autorizado.";
    }
}