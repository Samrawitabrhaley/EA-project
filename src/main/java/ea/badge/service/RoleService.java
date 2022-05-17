package ea.badge.service;

import ea.badge.domain.Badge;
import ea.badge.domain.Role;

import java.util.Collection;

public interface RoleService {
    Collection<Role> findAll();
    Role findById(Integer id);
    public Role addRole(Role role);
    public void removeRole(Integer id);
}
