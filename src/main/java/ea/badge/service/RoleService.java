package ea.badge.service;

import ea.badge.domain.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getAllRoles();

    Role getRoleById(Long id);

    Role addNewRole(Role role);

    void deleteRoleById(Long id);

    boolean existRoleById(long id);
}
