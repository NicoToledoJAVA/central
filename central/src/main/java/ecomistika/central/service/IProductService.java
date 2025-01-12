package ecomistika.central.service;

import ecomistika.central.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    public List<Product> getProducts();

    public Product getProductByCodeBar(String codeBar);

    public List<Product> getProductsByName(String name);

    public void saveProduct(Product product);

    public void deleteProduct(Long id);

    public Optional<Product> getProductById(Long id);

    public Product updateProduct(Long id, Product updatedProduct);

}
