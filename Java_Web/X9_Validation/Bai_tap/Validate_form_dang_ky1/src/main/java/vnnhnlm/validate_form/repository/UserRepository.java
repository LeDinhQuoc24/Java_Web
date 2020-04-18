package vnnhnlm.validate_form.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import vnnhnlm.validate_form.model.User;

public interface UserRepository extends PagingAndSortingRepository<User,String> {

    Page<User> findByFirstNameContaining(String firstName, Pageable pageable);

}
