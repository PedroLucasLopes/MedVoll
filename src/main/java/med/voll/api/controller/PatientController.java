package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.patient.Patient;
import med.voll.api.domain.patient.PatientRepository;
import med.voll.api.domain.patient.dto.createPatient;
import med.voll.api.domain.patient.dto.dataPatientDetail;
import med.voll.api.domain.patient.dto.listPatient;
import med.voll.api.domain.patient.dto.updatePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<dataPatientDetail> createPatient(@RequestBody @Valid createPatient data, UriComponentsBuilder uriBuilder) {
        Patient patient = new Patient(data);
        repository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new dataPatientDetail(patient));
    }

    @GetMapping
    public ResponseEntity<Page<listPatient>> readPatient(@PageableDefault(size = 10, sort = {"id"}) Pageable page) {
        Page<listPatient> list = repository.findAllByActiveTrue(page).map(listPatient::new);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<dataPatientDetail> readPatientById(@PathVariable Long id) {
        Patient getById = repository.getReferenceById(id);

        return ResponseEntity.ok(new dataPatientDetail(getById));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<dataPatientDetail> updatePatient(@RequestBody @Valid updatePatient data) {
        Patient patient = repository.getReferenceById(data.id());
        patient.updateInformation(data);

        return ResponseEntity.ok(new dataPatientDetail(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<dataPatientDetail> deletePatient(@PathVariable Long id) {
        Patient patient = repository.getReferenceById(id);
        patient.toggleActive();

        return ResponseEntity.noContent().build();
    }
}
