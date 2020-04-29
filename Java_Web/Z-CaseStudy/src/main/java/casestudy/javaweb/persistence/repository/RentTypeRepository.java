package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType,Long> {
}
