package vnnhnlm.validate_form.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vnnhnlm.validate_form.model.User;
import vnnhnlm.validate_form.repository.UserRepository;
import vnnhnlm.validate_form.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }



    @Override
    public Page<User> findByFirstNameContaining(String firstName,Pageable pageable) {
        return userRepository.findByFirstNameContaining(firstName,pageable);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void remove(String firstName) {


    }
}
