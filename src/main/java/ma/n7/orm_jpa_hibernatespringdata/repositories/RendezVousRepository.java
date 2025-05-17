package ma.n7.orm_jpa_hibernatespringdata.repositories;

import ma.n7.orm_jpa_hibernatespringdata.entities.RendezVous;
import ma.n7.orm_jpa_hibernatespringdata.enums.StatusRDV;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
    // Trouver tous les rendez-vous d’un patient
    List<RendezVous> findByPatientId(Long patientId);

    // Trouver tous les rendez-vous d’un médecin
    List<RendezVous> findByMedecinId(Long medecinId);

    // Filtrer par statut
    List<RendezVous> findByStatus(StatusRDV status);

    // Filtrer par date
    List<RendezVous> findByDate(Date date);
}