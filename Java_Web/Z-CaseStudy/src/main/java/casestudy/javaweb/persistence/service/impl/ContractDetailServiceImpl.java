package casestudy.javaweb.persistence.service.impl;

import casestudy.javaweb.persistence.entity.ContractDetail;
import casestudy.javaweb.persistence.repository.ContractDetailRepository;
import casestudy.javaweb.persistence.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Page<ContractDetail> findByQuantityContaining(String contractNumber, Pageable pageable) {
        return contractDetailRepository.findByQuantityContaining(contractNumber, pageable);
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);

    }
    @Override
    public void remove(Long id) {
        contractDetailRepository.deleteById(id);
    }
}
