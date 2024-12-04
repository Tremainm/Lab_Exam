package ie.atu.tremain_lab_exam;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotBlank(message = "Code must not be blank")
    private String productCode;
    @Max(value = 100, message = "String must be less than 100 characters")
    private String productName;
    @NotBlank(message = "Category must not be blank")
    private String category;
    @Positive(message = "Value must be positive")
    private int quantityInStock;
    @Positive(message = "Price must be positive")
    private double price;
}
