package casestudy.javaweb.persistence.service;


import casestudy.javaweb.persistence.entity.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();


    Part findById(Long id);

    void save(Part part);

    void remove(Long id);
}
