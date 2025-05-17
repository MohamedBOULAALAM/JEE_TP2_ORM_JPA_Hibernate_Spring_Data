package ma.n7.orm_jpa_hibernatespringdata;
import ma.n7.orm_jpa_hibernatespringdata.entities.*;
import ma.n7.orm_jpa_hibernatespringdata.enums.StatusRDV;
import ma.n7.orm_jpa_hibernatespringdata.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import java.util.UUID;


@SpringBootApplication
public class OrmJpaHibernateSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmJpaHibernateSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository
    ) {
        return args -> {
            // Ajouter des patients
            Patient p1 = patientRepository.save(new Patient(null, "Youssef", new Date(), false, 100));
            Patient p2 = patientRepository.save(new Patient(null, "Salma", new Date(), true, 90));

            // Ajouter des médecins
            Medecin m1 = medecinRepository.save(new Medecin(null, "Dr. Amine", "Cardiologie", null));
            Medecin m2 = medecinRepository.save(new Medecin(null, "Dr. Nadia", "Dermatologie", null));

            // Créer un rendez-vous pour p1 avec m1
            RendezVous rdv1 = new RendezVous();
            rdv1.setId(UUID.randomUUID().toString());
            rdv1.setDate(new Date());
            rdv1.setStatus(StatusRDV.PENDING);
            rdv1.setPatient(p1);
            rdv1.setMedecin(m1);
            rendezVousRepository.save(rdv1);

            // Créer un rendez-vous pour p2 avec m2
            RendezVous rdv2 = new RendezVous();
            rdv2.setId(UUID.randomUUID().toString());
            rdv2.setDate(new Date());
            rdv2.setStatus(StatusRDV.DONE);
            rdv2.setPatient(p2);
            rdv2.setMedecin(m2);
            rendezVousRepository.save(rdv2);

            // Ajouter une consultation liée à rdv1
            Consultation c1 = new Consultation();
            c1.setDateConsultation(new Date());
            c1.setRapport("Le patient est en bon état.");
            c1.setRendezVous(rdv1);
            consultationRepository.save(c1);
        };
    }
}
