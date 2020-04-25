package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part,Long> {
}
