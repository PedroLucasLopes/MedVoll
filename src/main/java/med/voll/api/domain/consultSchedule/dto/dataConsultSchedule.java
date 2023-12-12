package med.voll.api.domain.consultSchedule.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record dataConsultSchedule(
        Long professional_id,
        @NotNull
        Long patient_id,
        @NotNull
        @Future
        LocalDateTime data
) {
}
