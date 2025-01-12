/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.API.ImageGetter;
import ecomistika.central.dto.Nota;
import ecomistika.central.dto.MiniWineDTO;
import ecomistika.central.dto.WineDTO;
import ecomistika.central.model.Plato;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wines")
public class WineController {

    ImageGetter imageGetter = new ImageGetter();

    // Obtener todos los platos
    @GetMapping("/getAll")
    public ResponseEntity<List<MiniWineDTO>> getAllWines() {
        List<WineDTO> wines = getWineList();
        List<MiniWineDTO> table = new ArrayList<>();

        String imagen = null;

        for (WineDTO wine : wines) {
            MiniWineDTO row = new MiniWineDTO();

            row.setId(wine.getId());
            row.setPhoto(wine.getPhoto());
            row.setName(wine.getName());
            row.setType(wine.getType());
            row.setCategory(wine.getCategory());
            row.setPrice(wine.getPrice());
            row.setYear(wine.getYear());
            try {
                imagen = imageGetter.getImage(wine.getId());
                // Ejemplo de uso

                // Aquí podrías guardar el archivo en disco o procesarlo como necesites
            } catch (Exception e) {
                e.printStackTrace();
            }
            row.setPhoto(imagen);
            table.add(row);
        }
        return new ResponseEntity<>(table, HttpStatus.OK);
    }

    // Obtener un plato por ID
    @GetMapping("/getWine")
    public ResponseEntity<WineDTO> getWineById(@RequestParam Long id) {
        WineDTO wine = getWine(id);
        String imagen = null;
        try {
            imagen = imageGetter.getImage(wine.getId());
            // Ejemplo de uso

            // Aquí podrías guardar el archivo en disco o procesarlo como necesites
        } catch (Exception e) {
            e.printStackTrace();
        }
        wine.setPhoto(imagen);
        if (wine != null) {
            return new ResponseEntity<>(wine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public WineDTO getWine(Long id) {
        List<WineDTO> wines = getWineList();

        for (WineDTO wine : wines) {
            if (wine.getId() == id) {
                return wine;
            }
        }
        return null;
    }

    private List<WineDTO> getWineList() {
        List<WineDTO> wines = new ArrayList<>();
        WineDTO wine1 = WineDTO.builder()
                .id(1L)
                .barCode("1515923213234")
                .name("Callejón del Crimen")
                .type("Malbec")
                .Category("Gran Reserva")
                .price(93375.00)
                .year(2007)
                .acquisitionDate(LocalDateTime.of(2024, 9, 18, 10, 30))
                .alcoholPercentage(13.5)
                .region("Valle de Uco")
                .notas(Nota.builder()
                        .id(1L)
                        .color("Rojo violáceo")
                        .aroma("Frutos rojos, especias")
                        .sabor("Suave, equilibrado")
                        .build()).build();
        wines.add(wine1);

        WineDTO wine2 = WineDTO.builder()
                .id(2L)
                .barCode("2345276546738")
                .name("Altos del Plata")
                .type("Malbec")
                .Category("Reserva")
                .price(31125.00)
                .year(2019)
                .acquisitionDate(LocalDateTime.of(2023, 8, 12, 14, 0))
                .alcoholPercentage(14.0)
                .region("Mendoza")
                .notas(Nota.builder()
                        .id(2L)
                        .color("Rojo rubí")
                        .aroma("Cerezas maduras, madera")
                        .sabor("Intenso, estructurado")
                        .build()).build();
        wines.add(wine2);

        WineDTO wine3 = WineDTO.builder()
                .id(3L)
                .barCode("7654321234765")
                .name("Los Haroldos Estate")
                .type("Cabernet Sauvignon")
                .Category("Crianza")
                .price(27390.00)
                .year(2020)
                .acquisitionDate(LocalDateTime.of(2022, 5, 10, 9, 45))
                .alcoholPercentage(13.9)
                .region("San Juan")
                .notas(Nota.builder()
                        .id(3L)
                        .color("Rojo oscuro")
                        .aroma("Especias, pimientos")
                        .sabor("Fresco, con taninos suaves")
                        .build()).build();
        wines.add(wine3);

        WineDTO wine4 = WineDTO.builder()
                .id(4L)
                .barCode("9832736472834")
                .name("Don David")
                .type("Torrontés")
                .Category("Gran Reserva")
                .price(37350.00)
                .year(2017)
                .acquisitionDate(LocalDateTime.of(2021, 11, 5, 17, 15))
                .alcoholPercentage(13.0)
                .region("Salta")
                .notas(Nota.builder()
                        .id(4L)
                        .color("Amarillo brillante")
                        .aroma("Frutas tropicales, flores")
                        .sabor("Agradable, refrescante")
                        .build()).build();
        wines.add(wine4);

        WineDTO wine5 = WineDTO.builder()
                .id(5L)
                .barCode("5432167891234")
                .name("Catena Zapata")
                .type("Malbec + Doble Magnum")
                .Category("Gran Reserva")
                .price(87150.00)
                .year(2008)
                .acquisitionDate(LocalDateTime.of(2020, 2, 14, 12, 0))
                .alcoholPercentage(14.2)
                .region("Luján de Cuyo")
                .notas(Nota.builder()
                        .id(5L)
                        .color("Rojo profundo")
                        .aroma("Frutas negras, roble")
                        .sabor("Complejo, largo en boca")
                        .build()).build();
        wines.add(wine5);

        WineDTO wine6 = WineDTO.builder()
                .id(6L)
                .barCode("9827634523421")
                .name("Finca Las Moras")
                .type("Syrah")
                .Category("Reserva")
                .price(34860.00)
                .year(2018)
                .acquisitionDate(LocalDateTime.of(2023, 4, 21, 16, 0))
                .alcoholPercentage(13.8)
                .region("San Juan")
                .notas(Nota.builder()
                        .id(6L)
                        .color("Rojo intenso")
                        .aroma("Frutas maduras, chocolate")
                        .sabor("Elegante, de taninos suaves")
                        .build()).build();
        wines.add(wine6);

        WineDTO wine7 = WineDTO.builder()
                .id(7L)
                .barCode("2948723645127")
                .name("Trapiche")
                .type("Cabernet Sauvignon")
                .Category("Reserva")
                .price(24900.00)
                .year(2021)
                .acquisitionDate(LocalDateTime.of(2023, 7, 3, 11, 0))
                .alcoholPercentage(14.1)
                .region("Mendoza")
                .notas(Nota.builder()
                        .id(7L)
                        .color("Rojo rubí profundo")
                        .aroma("Pimientos asados, ciruela")
                        .sabor("Estructurado, persistente")
                        .build()).build();
        wines.add(wine7);

        WineDTO wine8 = WineDTO.builder()
                .id(8L)
                .barCode("3984726435712")
                .name("La Mascota")
                .type("Cabernet Franc")
                .Category("Crianza")
                .price(28635.00)
                .year(2020)
                .acquisitionDate(LocalDateTime.of(2022, 9, 12, 13, 30))
                .alcoholPercentage(13.7)
                .region("Mendoza")
                .notas(Nota.builder()
                        .id(8L)
                        .color("Rojo profundo")
                        .aroma("Frutas negras, especias")
                        .sabor("Equilibrado, final prolongado")
                        .build()).build();
        wines.add(wine8);

        WineDTO wine9 = WineDTO.builder()
                .id(9L)
                .barCode("8473629456718")
                .name("Salentein")
                .type("Pinot Noir")
                .Category("Crianza")
                .price(31125.00)
                .year(2019)
                .acquisitionDate(LocalDateTime.of(2023, 5, 23, 15, 0))
                .alcoholPercentage(13.5)
                .region("Valle de Uco")
                .notas(Nota.builder()
                        .id(9L)
                        .color("Rojo brillante")
                        .aroma("Frutas rojas, flores")
                        .sabor("Suave, elegante")
                        .build()).build();
        wines.add(wine9);

        WineDTO wine10 = WineDTO.builder()
                .id(10L)
                .barCode("4392871645231")
                .name("Andeluna")
                .type("Merlot")
                .Category("Crianza")
                .price(34860.00)
                .year(2018)
                .acquisitionDate(LocalDateTime.of(2021, 10, 5, 14, 15))
                .alcoholPercentage(13.9)
                .region("Tupungato")
                .notas(Nota.builder()
                        .id(10L)
                        .color("Rojo rubí")
                        .aroma("Frutas del bosque, especias")
                        .sabor("Aterciopelado, final largo")
                        .build()).build();
        wines.add(wine10);

        return wines;
    }

}
