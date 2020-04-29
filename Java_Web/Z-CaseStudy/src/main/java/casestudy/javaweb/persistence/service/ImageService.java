package casestudy.javaweb.persistence.service;

import casestudy.javaweb.persistence.entity.Image;
import casestudy.javaweb.persistence.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImageService {
    List<Image> findAll();

    List<Image> findByTypeContaining(String type);


    Image findById(Long id);

    void save(Image image);

    void remove(Long id);
}
