package ea.badge.service;

import ea.badge.domain.Role;

import java.util.List;

public interface RoleService {
    public Role addRole(Role role);
    public void removeRole(Integer id);

    public List<Role> findAll();
}
