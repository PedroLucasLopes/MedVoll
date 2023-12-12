package med.voll.api.domain.professional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Page<Professional> findAllByActiveTrue(Pageable page);
}
