package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {

}
