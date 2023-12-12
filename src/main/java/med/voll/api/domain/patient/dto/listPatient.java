package med.voll.api.domain.patient.dto;

import med.voll.api.domain.patient.Patient;

public record listPatient(Long id, String name, String email, String cpf) {
    public listPatient(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
