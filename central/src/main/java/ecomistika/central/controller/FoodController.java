/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.model.Plato;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/platos")
public class FoodController {

    // Obtener todos los platos
    @GetMapping("/traerPlatos")
    public ResponseEntity<List<Plato>> getAllPlatos() {
        List<Plato> platos = crearPlatos();
        return new ResponseEntity<>(platos, HttpStatus.OK);
    }

    // Obtener un plato por ID
    @GetMapping("/traerPlato")
    public ResponseEntity<Plato> getPlatoById(@RequestParam Long id) {
        Plato plato = traerPlato(id);
        if (plato != null) {
            return new ResponseEntity<>(plato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Plato traerPlato(Long id) {
        List<Plato> platos = crearPlatos();
        // Utilizar un bucle mejorado con Java 8 Streams para mayor claridad
        return platos.stream()
                .filter(plato -> plato.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Plato> crearPlatos() {
        // Crear una lista de platos
        List<Plato> platos = new ArrayList<>();

        // Crear los platos y almacenarlos en la lista
        platos.add(new Plato(1L, "Café Americano", "Café negro clásico.", 3.00, "Cafetería"));
        platos.add(new Plato(2L, "Capuchino", "Café con leche espumosa.", 3.75, "Cafetería"));
        platos.add(new Plato(3L, "Latte", "Café con leche al vapor.", 4.00, "Cafetería"));
        platos.add(new Plato(4L, "Muffin de Arándanos", "Muffin suave con arándanos frescos.", 2.50, "Cafetería"));
        platos.add(new Plato(5L, "Croissant", "Croissant recién horneado, crujiente y mantecoso.", 2.75, "Cafetería"));
        platos.add(new Plato(6L, "Sándwich de Jamón y Queso", "Sándwich caliente con jamón y queso derretido.", 5.50, "Cafetería"));
        platos.add(new Plato(7L, "Té Verde", "Té verde con un toque de limón.", 2.25, "Cafetería"));
        platos.add(new Plato(8L, "Pastel de Zanahoria", "Pastel de zanahoria con crema de queso.", 4.50, "Cafetería"));
        platos.add(new Plato(10L, "Spaghetti Bolognese", "Pasta con salsa de carne y tomate.", 12.50, "Principal"));
        platos.add(new Plato(11L, "Pizza Margherita", "Pizza con tomate, mozzarella y albahaca.", 10.00, "Principal"));
        platos.add(new Plato(12L, "Ensalada César", "Ensalada con lechuga, crutones y aderezo César.", 8.75, "Acompañamiento"));
        platos.add(new Plato(13L, "Sopa de Tomate", "Sopa cremosa de tomate con albahaca.", 6.50, "Aperitivo"));
        platos.add(new Plato(14L, "Tacos al Pastor", "Tacos de cerdo con piña y cilantro.", 9.25, "Principal"));
        platos.add(new Plato(15L, "Sushi Roll", "Roll de sushi con salmón, aguacate y arroz.", 14.00, "Principal"));
        platos.add(new Plato(16L, "Hamburguesa Clásica", "Hamburguesa con queso, lechuga y tomate.", 11.50, "Principal"));
        platos.add(new Plato(17L, "Risotto de Hongos", "Arroz cremoso con champiñones y parmesano.", 13.00, "Principal"));
        // Devolver la lista de platos
        return platos;
    }
}
