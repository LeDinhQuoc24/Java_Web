package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRepository extends PagingAndSortingRepository<Contract,Long> {
    Page<Contract> findByContractNumberContaining(String contractNumber, Pageable pageable);
}
