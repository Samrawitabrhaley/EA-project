package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.User;

import java.util.Collection;

public interface UserService {
    public Collection<User> getAllUsers();
    public User addUser(User user);
    public void deleteUser(Long id);
    public User getUserById(Long id);
    public Member login(String username, String password);
}
