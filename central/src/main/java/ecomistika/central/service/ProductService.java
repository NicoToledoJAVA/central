package ecomistika.central.service;

import ecomistika.central.model.Product;
import ecomistika.central.repository.IProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByCodeBar(String codeBar) {
        return productRepository.findByCodeBar(codeBar);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
       return productRepository.findById(id)
            .map(product -> {
                product.setName(updatedProduct.getName());
                // Actualizar los demás campos
                return productRepository.save(product);
            })
            .orElse(null);
    }

}
