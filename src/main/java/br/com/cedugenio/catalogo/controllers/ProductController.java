package br.com.cedugenio.catalogo.controllers;

import br.com.cedugenio.catalogo.model.entities.Product;
import br.com.cedugenio.catalogo.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/api/products")
public class ProductController {

    //Injeção de dependência
    @Autowired
    private ProductRepository productRepository;


    @PostMapping
     public @ResponseBody Product newProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
