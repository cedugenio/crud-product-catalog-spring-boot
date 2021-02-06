package br.com.cedugenio.catalogo.controllers;

import br.com.cedugenio.catalogo.model.entities.Product;
import br.com.cedugenio.catalogo.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/products")
public class ProductController {

    //Injecao de dependencia
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
     public @ResponseBody Product newProduct(Product product) {
        productRepository.save(product);
        return product;
    }
    @GetMapping
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<Product> getProductsPerName
            (@PathVariable String partName) {
        return productRepository.findByNameContainingIgnoreCase(partName);
    }


    @GetMapping(path = "/page/{pageNumber}/{quantityPages}")
    public Iterable<Product> getProductsPage
            (@PathVariable int pageNumber , @PathVariable int quantityPages) {
        if(quantityPages >= 5) quantityPages = 5;
        Pageable page = PageRequest.of(pageNumber, quantityPages);
        return productRepository.findAll(page);
    }

    @GetMapping(path="/{id}")
    public Optional<Product> getProductWithId(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @DeleteMapping(path="/{id}")
    public void deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
