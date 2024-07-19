package pl.coderslab.prostheticlab.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.prostheticlab.domain.User;
import pl.coderslab.prostheticlab.repository.RoleRepository;
import pl.coderslab.prostheticlab.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

private final UserRepository userRepository;

private final RoleRepository roleRepository;

private final BCryptPasswordEncoder passwordEncoder;

public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
}


    @Override
    public User findByUserName(String name) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
