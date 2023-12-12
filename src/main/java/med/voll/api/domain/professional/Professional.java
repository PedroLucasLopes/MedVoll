package med.voll.api.domain.professional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;
import med.voll.api.domain.professional.dto.createProfessional;
import med.voll.api.domain.professional.dto.updateProfessional;

@Table(name = "professionals")
@Entity(name = "Professional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professional {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;
    private Boolean active;

    public Professional(createProfessional data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
        this.active = true;
    }

    public void updateInformation(updateProfessional data) {
        if(data.name() != null) {
            this.name = data.name();
        }
        if(data.phone() != null) {
            this.phone = data.phone();
        }
        if(data.address() != null) {
            this.address.updateAddress(data.address());
        }
    }

    public void toggleActive() {
        this.active = false;
    }
}
