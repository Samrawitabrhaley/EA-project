package ea.badge.controller;

import ea.badge.domain.Role;
import ea.badge.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
    @DeleteMapping("/{id}")
    public void removeRole(@PathVariable Integer id){
        roleService.removeRole(id);
    }

    @GetMapping
    public List<Role> list(){return roleService.findAll();}


}
