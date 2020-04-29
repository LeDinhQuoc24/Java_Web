package casestudy.javaweb.persistence.service.impl;

import casestudy.javaweb.persistence.entity.Part;
import casestudy.javaweb.persistence.repository.PartRepository;
import casestudy.javaweb.persistence.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;
    @Override
    public List<Part> findAll() {
        return partRepository.findAll();
    }

    @Override
    public Part findById(Long id) {
        return partRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Part part) {
        partRepository.save(part);

    }

    @Override
    public void remove(Long id) {
        partRepository.deleteById(id);
    }
}
