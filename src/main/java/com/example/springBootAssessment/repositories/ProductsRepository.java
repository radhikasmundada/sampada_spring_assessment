package com.example.springBootAssessment.repositories;

import com.example.springBootAssessment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {


}
