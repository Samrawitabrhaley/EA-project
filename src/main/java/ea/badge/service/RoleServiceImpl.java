package ea.badge.service;

import ea.badge.domain.Role;
import ea.badge.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    public Collection<Role> findAll() { return roleRepository.findAll(); }

    public Role findById(Integer id) { return roleRepository.findById(id).get(); }

    @Override
    public Role addRole(Role role) {
       return roleRepository.save(role);
    }

    @Override
    public void removeRole(Integer id) {
        roleRepository.deleteById(id);

    }
}
