package Service;

import Model.Product;
import Repository.produtRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {
    private final produtRepository productRepo;

    public productService(produtRepository productRepository) {
        this.productRepo = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updatePrice(Long id, double price) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setPrice(price);
            return productRepo.save(product);
        }
        throw new RuntimeException("Product not found with id: " + id);
    }

    public Product updateStock(Long id, int stock) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setStock(stock);
            return productRepo.save(product);
        }
        throw new RuntimeException("Product not found with id: " + id);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
