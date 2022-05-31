package com.example.demo2.Data.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired private ProductReponsitpry repo;
    public List<Product> listAllPro(){
            return  (List<Product>) repo.findAll();
    }
    public void save(Product product){
        repo.save(product);
    }
    public List<Product> listAllProduct(){
        return (List<Product>) repo.findAll();
    }
    public Product get(Long id) throws ProductNotFoundException{
        Optional<Product> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }throw new ProductNotFoundException("Not found!!! by id"+id);
    }
}
