package ea.badge.service;

import ea.badge.domain.Role;
import ea.badge.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role addRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public void removeRole(Integer id) {
        roleRepository.deleteById(id);

    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
