package vnnhnlm.exam.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vnnhnlm.exam.persistence.entity.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {


}
