package casestudy.javaweb.persistence.service.impl;

import casestudy.javaweb.persistence.entity.Contract;
import casestudy.javaweb.persistence.repository.ContractRepository;
import casestudy.javaweb.persistence.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findByContractNumberContaining(String contractNumber, Pageable pageable) {
        return contractRepository.findByContractNumberContaining(contractNumber, pageable);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);

    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);

    }
}
