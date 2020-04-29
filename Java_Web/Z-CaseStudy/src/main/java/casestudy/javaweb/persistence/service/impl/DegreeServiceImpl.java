package casestudy.javaweb.persistence.service.impl;


import casestudy.javaweb.persistence.entity.Degree;
import casestudy.javaweb.persistence.repository.DegreeRepository;
import casestudy.javaweb.persistence.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeServiceImpl implements DegreeService {
    @Autowired
    private DegreeRepository degreeRepository;

    @Override
    public List<Degree> findAll() {
        return degreeRepository.findAll();
    }

    @Override
    public Degree findById(Long id) {
        return degreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Degree degree) {
        degreeRepository.save(degree);
    }

    @Override
    public void remove(Long id) {
        degreeRepository.deleteById(id);

    }
}

