package pl.coderslab.prostheticlab.service.user;

import pl.coderslab.prostheticlab.domain.User;

public interface UserService {

    User findByUserName(String name);

    User findByEmail(String email);

    void saveUser(User user);

    void deleteUser(User user);
}
