package ma.n7.orm_jpa_hibernatespringdata.repositories;

import ma.n7.orm_jpa_hibernatespringdata.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    // Optionnel : trouver une consultation par ID de rendez-vous
    Consultation findByRendezVousId(String rendezVousId);
}