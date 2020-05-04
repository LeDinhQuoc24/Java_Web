package vnnhnlm.exam.persistence.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnnhnlm.exam.persistence.entity.Image;
import vnnhnlm.exam.persistence.repository.ImageRepository;
import vnnhnlm.exam.persistence.service.ImageService;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void remove(Long id) {
        imageRepository.deleteById(id);
    }
}
