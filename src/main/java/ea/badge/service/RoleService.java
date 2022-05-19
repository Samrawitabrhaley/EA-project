package ea.badge.service;

import ea.badge.domain.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getAllRoles();

    Role getRoleById(Integer id);

    Role addNewRole(Role role);

    void deleteRoleById(Integer id);

    boolean existRoleById(long id);
}
