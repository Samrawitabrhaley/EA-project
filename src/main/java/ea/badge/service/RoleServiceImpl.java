package ea.badge.service;

import ea.badge.domain.Role;
import ea.badge.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void addRole(Role role) {
       roleRepository.save(role);
    }

    @Override
    public void removeRole(Integer id) {
        roleRepository.deleteById(id);

    }
}
