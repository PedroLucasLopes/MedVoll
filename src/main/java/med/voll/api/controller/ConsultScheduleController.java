package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consultSchedule.ConsultScheduleRepository;
import med.voll.api.domain.consultSchedule.dto.dataConsultSchedule;
import med.voll.api.domain.consultSchedule.dto.dataConsultScheduleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ConsultScheduleController {
    @Autowired
    private ConsultScheduleRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<dataConsultScheduleDetail> createSchedule(@RequestBody @Valid dataConsultSchedule data) {
        return ResponseEntity.ok(new dataConsultScheduleDetail(null, null, null, null));
    }
}
