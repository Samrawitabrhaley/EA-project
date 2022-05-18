package ea.badge.service;

import ea.badge.domain.Member;
import ea.badge.domain.Role;
import ea.badge.repository.MemberRepository;
import ea.badge.repository.RoleRepository;
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
class RoleServiceTest {
    List<Role> rolelist=new ArrayList<>();
    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;


    @BeforeEach
    public void setup() {

        Role role1=new Role(1L,"Student");
        Role role2=new Role(2L,"Faculty");
        rolelist.add(role1);
        rolelist.add(role2);

    }

    @Test
    void findAll() {
        Mockito.when(roleRepository.findAll()).thenReturn(rolelist);
        Collection<Role> actual = roleService.findAll();
        assertThat(actual).isEqualTo(rolelist);

    }

    @Test
    void findById() {
        Mockito.when(roleRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(rolelist.get(0)));
        Integer id=1;
        Role actual=roleService.findById(id);
        assertThat(actual.getName()).isEqualTo("Student");
    }

    @Test
    void addRole() {
        Role role3=new Role(1L,"Stuff");
        Mockito.when(roleRepository.save(role3)).thenReturn(role3);
        Role actual=roleService.addRole(role3);
        assertThat(actual).isEqualTo(role3);
    }

    @Test
    void removeRole() {
        roleService.removeRole(1);
        verify(roleRepository, times(1)).deleteById(1);
    }
}