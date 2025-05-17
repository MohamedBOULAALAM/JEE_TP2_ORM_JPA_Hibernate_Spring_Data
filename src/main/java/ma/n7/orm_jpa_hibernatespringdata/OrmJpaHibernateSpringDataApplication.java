package ma.n7.orm_jpa_hibernatespringdata;

import ma.n7.orm_jpa_hibernatespringdata.entities.Patient;
import ma.n7.orm_jpa_hibernatespringdata.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class OrmJpaHibernateSpringDataApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }


    @Override
    public void run(String... args) {
        patientRepository.save(new Patient(null, "Mohamed", new Date(), false, 100));
        patientRepository.save(new Patient(null, "Imane", new Date(), true, 80));
        patientRepository.save(new Patient(null, "Karim", new Date(), true, 120));

        patientRepository.findAll().forEach(p -> {
            System.out.println("**********************************************************************");
            System.out.println(p.getNom() + " |-------*****-------| -> Malade : " + p.isMalade());System.out.println("**********************************************************************");
            System.out.println("**********************************************************************");
        });

        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient != null) {
            patient.setScore(300);
            patientRepository.save(patient);
        }

        patientRepository.deleteById(2L);
    }
}
