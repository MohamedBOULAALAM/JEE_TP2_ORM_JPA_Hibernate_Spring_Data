package ma.n7.orm_jpa_hibernatespringdata.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String specialite;
    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;
}




