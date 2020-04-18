package vnnhnlm.validate_form.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vnnhnlm.validate_form.model.User;

public interface UserService {
    Page<User> findAll (Pageable pageable);

    Page<User> findByFirstNameContaining(String firstName,Pageable pageable);

    void save(User user);

    void remove(String firstName);
}
