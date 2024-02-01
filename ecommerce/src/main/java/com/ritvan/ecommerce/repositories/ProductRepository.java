package com.ritvan.ecommerce.repositories;

import com.ritvan.ecommerce.models.Category;
import com.ritvan.ecommerce.models.Product;
import com.ritvan.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Product findById(long id);

//    List<Product> findByUser(User user);
//
//    List<Product> getCardsByCategory(Category category);
}
