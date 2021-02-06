package br.com.cedugenio.catalogo.model.repositories;

import br.com.cedugenio.catalogo.model.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends
        PagingAndSortingRepository<Product, Integer> {

    public Iterable<Product> findByNameContainingIgnoreCase(String partName);

    @Query("SELECT p FROM Product p WHERE p.nome LIKE %:name%")
    public Iterable<Product>searchByNameLike(@Param("name") String name);

}
