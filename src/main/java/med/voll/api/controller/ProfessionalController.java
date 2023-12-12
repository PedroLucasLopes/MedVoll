package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.professional.dto.createProfessional;
import med.voll.api.domain.professional.Professional;
import med.voll.api.domain.professional.ProfessionalRepository;
import med.voll.api.domain.professional.dto.dataProfessionalDetail;
import med.voll.api.domain.professional.dto.listProfessional;
import med.voll.api.domain.professional.dto.updateProfessional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
    @Autowired
    private ProfessionalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<dataProfessionalDetail> createProfessional(@RequestBody @Valid createProfessional data, UriComponentsBuilder uriBuilder) {
        Professional professional = new Professional(data);
        repository.save(professional);

        var uri = uriBuilder.path("/professionals/{id}").buildAndExpand(professional.getId()).toUri();
        return ResponseEntity.created(uri).body(new dataProfessionalDetail(professional));
    }

    @GetMapping
    public ResponseEntity<Page<listProfessional>> readProfessional(@PageableDefault(size = 10, sort = {"id"}) Pageable page) {
        Page<listProfessional> list = repository.findAllByActiveTrue(page).map(listProfessional::new);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<dataProfessionalDetail> readProfessionalById(@PathVariable Long id) {
        Professional getById = repository.getReferenceById(id);

        return ResponseEntity.ok(new dataProfessionalDetail(getById));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<dataProfessionalDetail> updateProfessional(@RequestBody @Valid updateProfessional data) {
        Professional professional = repository.getReferenceById(data.id());
        professional.updateInformation(data);

        // Always return a DTO, return a JPA Entity Is a bad practice
        return ResponseEntity.ok(new dataProfessionalDetail(professional));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<dataProfessionalDetail> deleteProfessional(@PathVariable Long id) {
        Professional professional = repository.getReferenceById(id);
        professional.toggleActive();

        return ResponseEntity.noContent().build();
    }
}
