package med.voll.api.domain.consultSchedule.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record dataConsultScheduleDetail(
        Long id,
        Long professional_id,
        Long patient_id,
        LocalDateTime data
        ) {
}
