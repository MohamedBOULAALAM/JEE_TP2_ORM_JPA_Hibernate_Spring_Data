package ma.n7.orm_jpa_hibernatespringdata.Repository;
import ma.n7.orm_jpa_hibernatespringdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean malade);
    List<Patient> findByNomContains(String keyword);
}