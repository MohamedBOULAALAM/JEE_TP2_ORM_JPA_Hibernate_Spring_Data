package ma.n7.orm_jpa_hibernatespringdata.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Consultation {
    @Id
    @GeneratedValue
    private Long id;
    private Date dateConsultation;
    private String rapport;

    @OneToOne
    private RendezVous rendezVous;
}

