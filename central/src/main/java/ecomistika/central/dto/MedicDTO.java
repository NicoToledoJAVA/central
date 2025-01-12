/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.dto;

/**
 *
 * @author Nicolas
 */
public class MedicDTO {


    private Long id;
    private String nombreCompleto;
    private String sexo; // 'Masculino' o 'Femenino'
    private String especialidad;
    private int edad;
    private String universidad;
    private String telefonoContacto;

    public MedicDTO() {
    }

    public MedicDTO(Long id, String nombreCompleto, String sexo, String especialidad, int edad, String universidad, String telefonoContacto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.especialidad = especialidad;
        this.edad = edad;
        this.universidad = universidad;
        this.telefonoContacto = telefonoContacto;
    }

    

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    // Método toString para mostrar los detalles del médico
    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", sexo='" + sexo + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", edad=" + edad +
                ", universidad='" + universidad + '\'' +
                ", telefonoContacto='" + telefonoContacto + '\'' +
                '}';
    }
  
}
