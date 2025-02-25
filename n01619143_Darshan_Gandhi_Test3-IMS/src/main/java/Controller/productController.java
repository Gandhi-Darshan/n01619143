package Controller;

import Service.productService;
import Model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class productController {

    @RestController
    @RequestMapping("/products")
    public class ProductController {

        private final productService productService;

        public ProductController(productService productService) {
            this.productService = productService;
        }

        @GetMapping
        public ResponseEntity<List<Product>> getAllProducts() {
            return ResponseEntity.ok(productService.getAllProducts());
        }

        @PostMapping
        public ResponseEntity<Product> addProduct(@RequestBody Product product) {
            return ResponseEntity.ok(productService.getNewProduct(product));
        }

        @PatchMapping
        public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
            if (!updates.containsKey("price") || !updates.containsKey("stock")) {
                return ResponseEntity.badRequest().body(null);
            }

            double price = ((Number) updates.get("price")).doubleValue();
            int stock = ((Number) updates.get("stock")).intValue();

            return ResponseEntity.ok(productService.updateProduct(id, price, stock));
        }

        // Delete a product
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product deleted successfully.");
        }
    }
}
