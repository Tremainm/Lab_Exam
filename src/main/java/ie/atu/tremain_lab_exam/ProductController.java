package ie.atu.tremain_lab_exam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService myService;

    public ProductController(ProductService myService) {
        this.myService = myService;
    }
}
