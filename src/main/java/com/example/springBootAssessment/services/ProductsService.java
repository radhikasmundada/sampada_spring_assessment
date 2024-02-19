package com.example.springBootAssessment.services;

import com.example.springBootAssessment.exceptions.EntityNotFoundException;
import com.example.springBootAssessment.models.Product;
import com.example.springBootAssessment.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {


    @Autowired
    private ProductsRepository productRepository;


    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getItem(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
           return  product.get();
        }
        throw new EntityNotFoundException("product with given ID does not exist");
    }

    public String delete(Long id){
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return "product deleted successfully";
        }
        throw new EntityNotFoundException("Unable to delete Product as id doesn't exist");

    }

    public Object create(Product product) {
        return productRepository.save(product);
    }

    public Object update(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if (productOptional.isPresent()) {
            productOptional.get().setName(product.getName());
            productOptional.get().setDescription(product.getDescription());
            productOptional.get().setPrice(product.getPrice());
            return productRepository.save(productOptional.get());
        }
        throw new EntityNotFoundException("Unable to update product as id doesn't exist");
    }
}
