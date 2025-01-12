/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.model.Category;
import ecomistika.central.model.Stock;
import ecomistika.central.service.ICategoryService;
import ecomistika.central.service.IStockService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
          @Autowired
    private ICategoryService catServ;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return catServ.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return catServ.getCategoryById(id);
    }

     @PostMapping("/create")
    public Category createCategoryItem(@RequestBody Category category) {
        return catServ.createCategory(category);
    }

    @PutMapping("/modify")
    public Category updateCategory(@RequestBody Category category) {
        Long id = category.getId();
        return catServ.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        catServ.deleteCategory(id);
    }
    
}
