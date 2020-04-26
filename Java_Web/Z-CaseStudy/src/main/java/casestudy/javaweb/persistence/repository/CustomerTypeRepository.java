package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
