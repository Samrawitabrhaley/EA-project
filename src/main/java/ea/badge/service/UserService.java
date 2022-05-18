package ea.badge.service;

import ea.badge.domain.User;

import java.util.Collection;

public interface UserService {
    public Collection<User> getAllUsers();
    public User addUser(User user);
    public void deleteUser(Integer id);
    public User getUserById(Integer id);
}
