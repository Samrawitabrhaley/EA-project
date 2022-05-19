package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.User;
import ea.badge.exception.ResourceNotFoundException;
import ea.badge.repository.MemberRepository;
import ea.badge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MemberRepository memberRepository;
    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public Member login(String username, String password) {

      Member found=  memberRepository.findByUserNamePwd(username,password);
      System.out.println("member = "+ found);
      if(found ==null) throw new ResourceNotFoundException();
      return found;
    }
}
