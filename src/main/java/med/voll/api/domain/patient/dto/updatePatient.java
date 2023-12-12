package med.voll.api.domain.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.dto.CreateAddress;

public record updatePatient(
        @NotNull
        Long id,
        String name,
        String cpf,
        String email,
        CreateAddress address
) {
}
