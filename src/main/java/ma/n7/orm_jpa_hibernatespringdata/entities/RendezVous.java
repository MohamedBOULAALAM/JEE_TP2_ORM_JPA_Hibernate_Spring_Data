package ma.n7.orm_jpa_hibernatespringdata.entities;
import jakarta.persistence.*;
import lombok.Data;
import ma.n7.orm_jpa_hibernatespringdata.enums.StatusRDV;
import java.util.Date;

@Data
@Entity
public class RendezVous {
    @Id
    private String id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}

