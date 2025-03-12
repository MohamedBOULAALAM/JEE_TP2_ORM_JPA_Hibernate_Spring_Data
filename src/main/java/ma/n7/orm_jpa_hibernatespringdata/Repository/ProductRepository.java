package ma.n7.orm_jpa_hibernatespringdata.Repository;

import ma.n7.orm_jpa_hibernatespringdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String keyword);

    @Query("select p from Product p where p.name like :x")
    List<Product> searchByName(@Param("x") String keyword);

    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.price > :x")
    List<Product> searchByPrice(@Param("x") double price);
}
