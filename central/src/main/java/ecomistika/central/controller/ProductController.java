package ecomistika.central.controller;

import ecomistika.central.dto.ProductDTO;
import ecomistika.central.model.Product;
import ecomistika.central.service.IProductService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    public String saveItem(@RequestParam String name, @RequestParam String description, @RequestParam Double price,
            @RequestParam Integer stockQuantity,
            @RequestParam String codeBar) {

        Product nuevoProd = new Product();
        nuevoProd.setName(name);
        nuevoProd.setDescription(description);
        nuevoProd.setPrice(price);

        nuevoProd.setCodeBar(codeBar);
        productService.saveProduct(nuevoProd);
        return "producto creado";
    }

    @PostMapping("/getListFast")
    public List<ProductDTO> getListOfProductsForTesting() {
        // Lista que se devolverá al frontend
        List<ProductDTO> listaFront = new ArrayList<>();

        // Productos predefinidos para pruebas
        listaFront.add(new ProductDTO("29", "Aceite de Ricino Uso Externo \"PF\" 30ml", 2900.0, "29", 15));
        listaFront.add(new ProductDTO("36", "Aji de Cayena 50g", 894.0, "36", 20));
        listaFront.add(new ProductDTO("38", "Ajo 1000 Garden House 30 Comp", 9082.0, "38", 30));
        listaFront.add(new ProductDTO("42", "Algas para Sushi 5u", 3120.25, "42", 2));
        listaFront.add(new ProductDTO("50", "Almidón de Maiz Aldema S/TACC 500g", 1174.0, "50", 10));
        listaFront.add(new ProductDTO("55", "Amapola Azul 25g", 729.0, "55", 150));
        listaFront.add(new ProductDTO("56", "Amaranto 100g", 870.0, "56", 130));
        listaFront.add(new ProductDTO("60", "Anis en Grano 25g", 734.0, "60", 180));
        listaFront.add(new ProductDTO("64", "Aritos de Miel 200g", 1802.0, "64", 160));
        listaFront.add(new ProductDTO("65", "Aritos Frutales 200g", 1989.5, "65", 17));
        listaFront.add(new ProductDTO("67", "Arroz integral fino 500g", 1125.6, "67", 550));
        listaFront.add(new ProductDTO("74", "Avena Arg. Instantanea Premium 500g", 1773.2, "74", 60));
        listaFront.add(new ProductDTO("78", "Avena Tradicional Premium 500g", 1707.2, "78", 6));
        listaFront.add(new ProductDTO("86", "Bicarbonato de Sodio 200g", 1600.0, "86", 7));
        listaFront.add(new ProductDTO("94", "Calcio 500  Garden House 40comp", 8870.0, "94", 80));
        listaFront.add(new ProductDTO("95", "Canela en Rama 15g", 1170.0, "95", 15));
        listaFront.add(new ProductDTO("97", "Canela Molida 50g", 1323.0, "97", 10));
        listaFront.add(new ProductDTO("99", "Caramelo Propoleo Lindon Apiter MENTA", 200.26, "99", 20));
        listaFront.add(new ProductDTO("100", "Caramelo Propoleo Lindon Apiter MIEL", 200.26, "100", 30));
        listaFront.add(new ProductDTO("101", "Cardo Mariano Tintura Fatima", 2160.0, "101", 40));
        listaFront.add(new ProductDTO("106", "Cebada Perlada", 1158.0, "106", 90));
        listaFront.add(new ProductDTO("108", "Cebolla en escama 50g", 806.0, "108", 80));
        listaFront.add(new ProductDTO("109", "Centella Asiática Garden House 60comp", 8530.0, "109", 110));
        listaFront.add(new ProductDTO("113", "Chia 100g", 692.0, "113", 1110));
        listaFront.add(new ProductDTO("115", "Chia Caps Garden House 60Comp", 16200.0, "115", 90));

       
        return listaFront;
    }

    @PostMapping("/getList")
    public List<ProductDTO> getListeOfProducts() {
        List<Product> productosBase = new ArrayList<>();
        List<ProductDTO> listaFront = new ArrayList<>();

        Integer limitador = 0;

        try {
            productosBase = productService.getProducts();
        } catch (Error e) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, e);
        }

        if (productosBase != null) {
            for (Product prod : productosBase) {
                if (limitador >= 25) {
                    break;  // Sal del bucle si se alcanzan los 50 productos
                }
                // Crear una nueva instancia de ProductDTO para cada producto
                ProductDTO productFront = new ProductDTO();
                productFront.setProduct_number(prod.getProduct_number());
                productFront.setName(prod.getName());
                productFront.setPrice(prod.getPrice());
                productFront.setCodeBar(prod.getCodeBar());
                if (prod.getStock() != null) {
                    productFront.setStock(prod.getStock().getCurrentStock());
                } else {
                    // Maneja el caso cuando el stock es null
                    productFront.setStock(0);  // Suponiendo que 0 sea un valor válido
                }
                // Añadir el DTO a la lista
                listaFront.add(productFront);
                limitador++;
            }
        }

        return listaFront;
    }

    @PostMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/getByCodeBar")
    public ResponseEntity<ProductDTO> getProductByCodeBar(@RequestParam String codeBar) {
        Product product = productService.getProductByCodeBar(codeBar);

        if (product != null) {
            ProductDTO productFront = new ProductDTO();
            productFront.setProduct_number(product.getProduct_number());
            productFront.setName(product.getName());
            productFront.setPrice(product.getPrice());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

            return new ResponseEntity<>(productFront, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<ProductDTO>> getProductsByName(@RequestParam String name) {

        List<Product> products = productService.getProductsByName(name);

        if (!products.isEmpty()) {
            List<ProductDTO> productsDTO = new ArrayList<>();

            for (Product product : products) {
                ProductDTO productFront = new ProductDTO();
                productFront.setProduct_number(product.getProduct_number());
                productFront.setName(product.getName());
                productFront.setPrice(product.getPrice());
                productsDTO.add(productFront);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

            return new ResponseEntity<>(productsDTO, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/deleteAll")
    public String corregir() {
        List<Product> listaProductos = productService.getProducts();
        int borrado = 0;
        int total = 0;
        int quedaron = 0;
        for (Product prod : listaProductos) {
            total++;
            if (prod.getId_product() > 520) {
                productService.deleteProduct(prod.getId_product());
                borrado++;
            } else {
                quedaron++;
            }
        }

        return "Borramos: " + borrado + " Productos. \nQuedaron: " + quedaron + " Productos. \nTotal: " + total + " Productos.";
    }

}
