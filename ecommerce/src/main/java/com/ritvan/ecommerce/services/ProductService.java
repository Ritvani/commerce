package com.ritvan.ecommerce.services;


import com.ritvan.ecommerce.models.Product;
import com.ritvan.ecommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;


@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    UserService userService;

    public byte[] getImage(long productId){
        Product product = productRepository.findById(productId);
        return product.getPhoto().getBytes();
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }
    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    public Product findProductById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getTopCards() {
        List<Product> allProducts = productRepository.findAll();

        int totalProducts = allProducts.size();

        if (totalProducts<=3){
            return allProducts;
        } else {
            return allProducts.subList(totalProducts - 3, totalProducts);
        }
    }

}