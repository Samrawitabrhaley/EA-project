package ea.badge.controller;

import ea.badge.domain.Role;
import ea.badge.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public Collection<Role> getAll() { return roleService.findAll(); }
    @GetMapping("/{id}")
    public Role getById(@PathVariable("id") Integer id) { return roleService.findById(id); }
    @PostMapping
    public void addRole(Role role){
        roleService.addRole(role);
    }
    @DeleteMapping("/{id}")
    public void removeRole(@PathVariable Integer id){
        roleService.removeRole(id);
    }
}
