package casestudy.javaweb.persistence.service;

import casestudy.javaweb.persistence.entity.Accompany;
import java.util.List;

public interface AccompanyService {

    List<Accompany> findAll();

    Accompany findById(Long id);

    void save(Accompany accompany);

    void remove(Long id);
}
