package med.voll.api.domain.professional.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.dto.CreateAddress;

public record updateProfessional(
        @NotNull
        Long id,
        String name,
        String phone,
        CreateAddress address) {
}
