package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Image;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image> findByTypeContaining(String type);

}
