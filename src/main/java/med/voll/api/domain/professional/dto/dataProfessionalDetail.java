package med.voll.api.domain.professional.dto;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.professional.Specialty;
import med.voll.api.domain.professional.Professional;

public record dataProfessionalDetail(Long id, String name, String email, String crm, String phone, Specialty specialty, Address address) {
    public dataProfessionalDetail(Professional professional) {
        this(
                professional.getId(),
                professional.getName(),
                professional.getEmail(),
                professional.getCrm(),
                professional.getPhone(),
                professional.getSpecialty(),
                professional.getAddress()
        );
    }
}
