package casestudy.javaweb.persistence.service.impl;

import casestudy.javaweb.persistence.entity.Accompany;
import casestudy.javaweb.persistence.repository.AccompanyRepository;
import casestudy.javaweb.persistence.service.AccompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccompanyServiceImpl implements AccompanyService {
    @Autowired
    private AccompanyRepository accompanyRepository;

    @Override
    public List<Accompany> findAll() {
        return accompanyRepository.findAll();
    }

    @Override
    public Accompany findById(Long id) {
        return accompanyRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Accompany accompany) {
        accompanyRepository.save(accompany);
    }

    @Override
    public void remove(Long id) {
        accompanyRepository.deleteById(id);
    }
}
