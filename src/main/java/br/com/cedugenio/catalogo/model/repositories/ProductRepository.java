package br.com.cedugenio.catalogo.model.repositories;

import br.com.cedugenio.catalogo.model.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends
        CrudRepository<Product, Integer> {

}
