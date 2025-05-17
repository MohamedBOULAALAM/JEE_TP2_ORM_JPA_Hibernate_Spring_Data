package ma.n7.orm_jpa_hibernatespringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmJpaHibernateSpringDataApplication implements CommandLineRunner {
    @Autowired


    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
