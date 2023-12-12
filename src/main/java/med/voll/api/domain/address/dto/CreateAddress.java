package med.voll.api.domain.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAddress(
        @NotBlank
        String public_place,
        @NotBlank
        String district,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipcode,
        @NotBlank
        String city,
        @NotBlank
        String fu,
        String complement,
        String number) {
}
