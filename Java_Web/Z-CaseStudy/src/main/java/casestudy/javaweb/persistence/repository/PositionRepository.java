package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
