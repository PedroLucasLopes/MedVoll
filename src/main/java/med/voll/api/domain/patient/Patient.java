package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;
import med.voll.api.domain.patient.dto.createPatient;
import med.voll.api.domain.patient.dto.updatePatient;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String cpf;
    @Embedded
    private Address address;
    private Boolean active;

    public Patient(createPatient data) {
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
        this.active = true;
    }

    public void updateInformation(updatePatient data) {
        if(data.name() != null) {
            this.name = data.name();
        }

        if(data.cpf() != null) {
            this.cpf = data.cpf();
        }

        if(data.email() != null) {
            this.email = data.email();
        }

        if(data.address() != null) {
            this.address.updateAddress(data.address());
        }
    }

    public void toggleActive() {
        this.active = false;
    }
}
