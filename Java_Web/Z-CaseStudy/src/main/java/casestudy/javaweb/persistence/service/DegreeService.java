package casestudy.javaweb.persistence.service;

import casestudy.javaweb.persistence.entity.Degree;


import java.util.List;

public interface DegreeService {
    List<Degree> findAll();

    Degree findById(Long id);

    void save(Degree degree);

    void remove(Long id);
}
