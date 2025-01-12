/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.Category;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    
    
    public List<Category> getAllCategories();

    public Optional<Category> getCategoryById(Long id);

    public Category createCategory(Category category);

    public Category updateCategory(Category category);

    public void deleteCategory(Long id);
    
}
