package casestudy.javaweb.persistence.service;

import casestudy.javaweb.persistence.entity.Contract;
import casestudy.javaweb.persistence.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    Page<ContractDetail> findByQuantityContaining(String contractNumber, Pageable pageable);

    ContractDetail findById(Long id);

    void save(ContractDetail contractDetail);

    void remove(Long id);


}
