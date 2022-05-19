package ea.badge.controller;

import ea.badge.domain.Role;
import ea.badge.dto.RoleDto;
import ea.badge.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping()
    public Collection<RoleDto> getAll() { return this.roleService.findAll().stream()
            .map(role -> mapper.map(role, RoleDto.class)).collect(Collectors.toList());}

    @GetMapping("{id}")
    public RoleDto getById(@PathVariable("id") Integer id){
        return mapper.map(roleService.findById(id), RoleDto.class);
    }
    @PostMapping
    public RoleDto addRole(@RequestBody Role role){

        return mapper.map(roleService.addRole(mapper.map(role, Role.class)), RoleDto.class);
    }
    @DeleteMapping("/{id}")
    public void removeRole(@PathVariable Integer id){
        roleService.removeRole(id);
    }
}
