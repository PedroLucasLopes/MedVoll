package med.voll.api.domain.patient.dto;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.patient.Patient;

public record dataPatientDetail(Long id, String name, String email, String cpf, Address address) {
    public dataPatientDetail(Patient patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getCpf(),
                patient.getAddress()
        );
    }
}
