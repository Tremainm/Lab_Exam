package ie.atu.tremain_lab_exam;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService myService;

    public ProductController(ProductService myService) {
        this.myService = myService;
    }

    private List<Product> list = new ArrayList<>();

    @GetMapping("")
    public List<Product> getProduct(String productCode)
    {
        list = myService.getProducts(productCode);
        return list;
    }

    @PostMapping("")
    public List<Product> addProduct(@Valid @RequestBody Product product)
    {
        list = myService.addProducts(product);
        return list;
    }

    @PutMapping("/{productCode}")
    public List<Product> updateProduct(@Valid Product product, String productCode)
    {
        list = myService.updateProducts(product, productCode);
        return list;
    }

    @DeleteMapping("/{productCode}")
    public List<Product> deleteProduct(@Valid String productCode)
    {
        list = myService.deleteProducts(productCode);
        return list;
    }
}
