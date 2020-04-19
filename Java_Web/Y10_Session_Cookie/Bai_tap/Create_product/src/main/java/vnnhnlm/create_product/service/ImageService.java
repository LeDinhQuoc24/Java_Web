package vnnhnlm.create_product.service;

import vnnhnlm.create_product.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> findAll();

    Image findById(Long id);

    void save(Image image);

    void remove(Long id);
}
