package vnnhnlm.create_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnnhnlm.create_product.model.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
