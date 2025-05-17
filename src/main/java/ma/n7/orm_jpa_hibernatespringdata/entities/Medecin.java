package ma.n7.orm_jpa_hibernatespringdata.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Medecin {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String specialite;
    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
}