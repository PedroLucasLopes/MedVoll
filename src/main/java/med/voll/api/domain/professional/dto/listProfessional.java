package med.voll.api.domain.professional.dto;

import med.voll.api.domain.professional.Professional;
import med.voll.api.domain.professional.Specialty;

public record listProfessional(Long id, String name, String email, String crm, Specialty specialty) {
    public listProfessional(Professional professional) {
        this(professional.getId(), professional.getName(), professional.getEmail(), professional.getCrm(), professional.getSpecialty());
    }
}
