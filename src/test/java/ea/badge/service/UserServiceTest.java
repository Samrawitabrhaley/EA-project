package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.User;
import ea.badge.repository.MemberRepository;
import ea.badge.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    List<User> userList=new ArrayList<>();
    @Mock
    private UserRepository userRepository;
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @BeforeEach
    public void setup() {

        User user1=new User(1L,"samri","samri123");
        User user2=new User(2L,"bisr","bisr123");
        userList.add(user1);
        userList.add(user2);

    }


    @Test
    void getAllUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        Collection<User> actual = userService.getAllUsers();
        assertThat(actual).isEqualTo(userList);
    }

    @Test
    void addUser() {
        User user3=new User(1L,"ashok","ashok123");
        Mockito.when(userRepository.save(user3)).thenReturn(user3);
        User actual=userService.addUser(user3);
        assertThat(actual).isEqualTo(user3);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void getUserById() {
        Mockito.when(userRepository.getById(1L)).thenReturn(userList.get(0));
        Long id=1L;
        User actual=userService.getUserById(id);
        assertThat(actual.getUsername()).isEqualTo("samri");
    }

    @Test
    void login() {
        Member member=new Member(1L,"samri","Abrha","samri@gmail.com");
        Mockito.when(memberRepository.findByUserNamePwd("samri","samri123")).thenReturn(member);
        Member actual=userService.login("samri","samri123");
        assertThat(actual).isEqualTo(member);

    }
}