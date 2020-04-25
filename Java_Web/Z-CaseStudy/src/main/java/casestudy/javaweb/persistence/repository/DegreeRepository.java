package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree,Long> {
}
