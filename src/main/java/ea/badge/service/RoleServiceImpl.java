package ea.badge.service;

import ea.badge.domain.Role;
import ea.badge.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    public Collection<Role> getAllRoles() { return roleRepository.findAll(); }

    public Role getRoleById(Integer id) { return roleRepository.getById(id); }

    @Override
    public Role addNewRole(Role role) {
       return roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Integer id) {
        roleRepository.deleteById(id);

    }

    @Override
    public boolean existRoleById(long id) {
        return roleRepository.existsById((int) id);
    }
}
