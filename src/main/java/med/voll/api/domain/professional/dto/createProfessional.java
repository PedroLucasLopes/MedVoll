package med.voll.api.domain.professional.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.dto.CreateAddress;
import med.voll.api.domain.professional.Specialty;

public record createProfessional(
        @NotBlank // NotNull and NotEmpty
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "(\\d{4,6})")
        String crm,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        CreateAddress address) {
}
