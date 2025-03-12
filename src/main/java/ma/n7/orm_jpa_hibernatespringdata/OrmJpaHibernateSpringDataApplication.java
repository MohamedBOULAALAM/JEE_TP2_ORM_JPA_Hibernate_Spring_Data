package ma.n7.orm_jpa_hibernatespringdata;

import ma.n7.orm_jpa_hibernatespringdata.Repository.ProductRepository;
import ma.n7.orm_jpa_hibernatespringdata.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmJpaHibernateSpringDataApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        productRepository.save(new Product(1, "Computer", 9000, 3));
        productRepository.save(new Product(2, "Printer", 3000, 2));
        productRepository.save(new Product(3, "Smartphone", 8000, 5));
    }
}
