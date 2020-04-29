package casestudy.javaweb.persistence.service;


import casestudy.javaweb.persistence.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();


    Position findById(Long id);

    void save(Position position);

    void remove(Long id);
}
