package ma.n7.orm_jpa_hibernatespringdata.repositories;

import ma.n7.orm_jpa_hibernatespringdata.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    // Chercher par spécialité
    List<Medecin> findBySpecialite(String specialite);

    // Rechercher les noms contenant un mot-clé
    List<Medecin> findByNomContains(String keyword);
}