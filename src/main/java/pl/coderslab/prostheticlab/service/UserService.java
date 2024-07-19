package pl.coderslab.prostheticlab.service;

import pl.coderslab.prostheticlab.domain.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
