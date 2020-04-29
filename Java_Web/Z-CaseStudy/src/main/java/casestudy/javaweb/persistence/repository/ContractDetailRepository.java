package casestudy.javaweb.persistence.repository;

import casestudy.javaweb.persistence.entity.Contract;
import casestudy.javaweb.persistence.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractDetailRepository extends PagingAndSortingRepository<ContractDetail,Long> {
    Page<ContractDetail> findByQuantityContaining(String contractNumber, Pageable pageable);
}
