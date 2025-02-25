package Service;

import Model.Product;
import Repository.produtRepository;

import java.util.List;
import java.util.Optional;

public class productService {
    private final produtRepository productRepo;

    public productService(produtRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getNewProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Long id, double price, int stock) {
        Optional<Product> existingProduct = produtRepository.findByID(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setPrice(price);
            product.setStock(stock);
            return produtRepository.save(product);
        }
        throw new RuntimeException("Product not found with id: " + id);
    }


    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }
}
