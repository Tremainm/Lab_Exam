package ie.atu.tremain_lab_exam;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    private List<Product> myList = new ArrayList<>();
    public List<Product> getProducts(String productCode)
    {
        for (Product p : myList)
        {
            if (p.getProductCode() == productCode)
            {
                return myList;
            }
        }
        throw new NoSuchElementException("Product with product code" + productCode + " not found");
    }

    public List<Product> addProducts(Product product)
    {
        myList.add(product);
        return myList;
    }

    public List<Product> updateProducts(Product product, String productCode)
    {
        for (Product p : myList)
        {
            if (p.getProductCode() == productCode)
            {
                p.setProductName(product.getProductName());
                p.setCategory(product.getCategory());
                p.setQuantityInStock(product.getQuantityInStock());
                p.setPrice(product.getPrice());
                return myList;
            }
        }
        throw new NoSuchElementException("Product with product code" + productCode + " not found");
    }

    public List<Product> deleteProducts(String productCode)
    {
        for (Product p : myList)
        {
            if (p.getProductCode() == productCode)
            {
                myList.remove(p);
            }
        }
        return myList;
    }
}
