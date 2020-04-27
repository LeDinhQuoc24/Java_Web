package casestudy.javaweb.persistence.service;

import casestudy.javaweb.persistence.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findByContractNumberContaining(String contractNumber, Pageable pageable);

    Contract findById(Long id);

    void save(Contract contract);

    void remove(Long id);
}
