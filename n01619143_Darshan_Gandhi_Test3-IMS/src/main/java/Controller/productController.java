package Controller;

import Model.Product;
import Service.productService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/products")
public class productController {

    private final productService productService;

    public productController(productService productService) {
        this.productService = productService;
    }

    // Show all products
    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products"; // Returns products.html
    }

    // Show form to add a new product
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // Handle adding a new product
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "add-product";
        }
        productService.addProduct(product);
        return "redirect:/products";
    }

    // Show form to update price
    @GetMapping("/edit/{id}")
    public String showUpdatePriceForm(@PathVariable Long id, Model model) {
        Product product = productService.getAllProducts().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "edit-price"; // Returns edit-price.html
    }

    // Handle updating price
    @PostMapping("/update/{id}/price")
    public String updatePrice(@PathVariable Long id, @RequestParam double price) {
        productService.updatePrice(id, price);
        return "redirect:/products";
    }

    // Show form to update stock
    @GetMapping("/update/{id}/stock")
    public String showUpdateStockForm(@PathVariable Long id, Model model) {
        Product product = productService.getAllProducts().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "edit-stock"; // Returns edit-stock.html
    }

    // Handle updating stock
    @PostMapping("/update/{id}/stock")
    public String updateStock(@PathVariable Long id, @RequestParam int stock) {
        productService.updateStock(id, stock);
        return "redirect:/products";
    }

    // Delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}