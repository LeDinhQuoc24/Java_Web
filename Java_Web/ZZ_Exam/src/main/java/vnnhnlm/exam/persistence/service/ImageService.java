package vnnhnlm.exam.persistence.service;


import vnnhnlm.exam.persistence.entity.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAll();

    Image findById(Long id);

    void save(Image image);

    void remove(Long id);
}
