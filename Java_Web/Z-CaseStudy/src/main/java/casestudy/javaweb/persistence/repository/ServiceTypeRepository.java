package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
