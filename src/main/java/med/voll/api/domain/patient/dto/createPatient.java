package med.voll.api.domain.patient.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.dto.CreateAddress;

public record createPatient(
        @NotBlank // NotNull and NotEmpty
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "(\\d{11})")
        String cpf,
        @NotNull
        @Valid
        CreateAddress address) {
}
