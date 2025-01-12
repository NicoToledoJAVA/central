/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.dto.MedicDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicina")
public class MedicController {
    
    @GetMapping("/getMedics")
    public ResponseEntity<List<MedicDTO>> getAllWines() {
        List<MedicDTO> medico = crearDiezMedicos();
        
       
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }
    
    @GetMapping("/recomendacion")
    public String getRecommendation(@RequestParam double imc) {
        String resultMessage;

        if (imc < 18.5) {
            resultMessage = "El Lunes te espera la nutricionista, ¡Terminás con ella y me venís a ver a mi!";
        } else if (imc >= 18.5 && imc < 25) {
            resultMessage = "¡Te felicito, tu peso es Normal!";
        } else if (imc >= 25 && imc < 30) {
            resultMessage = "¡Tranquilo!... El sobrepeso es más un problema estético que médico.";
        } else {
            resultMessage = "¡Estás con Obesidad, tenés que ver primero al cardiologo y luego pasar por acá!";
        }

        return resultMessage;
    }
    
    public List<MedicDTO> crearDiezMedicos() {
        List<MedicDTO> medicos = new ArrayList<>();

        medicos.add(new MedicDTO(1L, "Dr. Juan Pérez", "Masculino", "Cardiología", 45, "Universidad de Buenos Aires", "123456789"));
        medicos.add(new MedicDTO(2L, "Dra. María López", "Femenino", "Pediatría", 38, "Universidad Nacional de La Plata", "987654321"));
        medicos.add(new MedicDTO(3L, "Dr. Carlos Rodríguez", "Masculino", "Neurología", 50, "Universidad de Córdoba", "456789123"));
        medicos.add(new MedicDTO(4L, "Dra. Laura Gómez", "Femenino", "Ginecología", 40, "Universidad Nacional de Rosario", "654321987"));
        medicos.add(new MedicDTO(5L, "Dr. Pablo Fernández", "Masculino", "Traumatología", 35, "Universidad Nacional del Nordeste", "321654987"));
        medicos.add(new MedicDTO(6L, "Dra. Ana Martínez", "Femenino", "Dermatología", 42, "Universidad Nacional del Sur", "741852963"));
        medicos.add(new MedicDTO(7L, "Dr. Enrique González", "Masculino", "Psiquiatría", 55, "Universidad Nacional de Tucumán", "963852741"));
        medicos.add(new MedicDTO(8L, "Dra. Sofía Sánchez", "Femenino", "Oftalmología", 37, "Universidad Nacional de Cuyo", "159753486"));
        medicos.add(new MedicDTO(9L, "Dr. Luis Ramírez", "Masculino", "Cirugía General", 48, "Universidad Nacional del Comahue", "258369147"));
        medicos.add(new MedicDTO(10L, "Dra. Claudia Núñez", "Femenino", "Endocrinología", 46, "Universidad Nacional de San Juan", "753159486"));

        return medicos;
    }
    
}
