package ea.badge.controller;

import ea.badge.domain.Role;
import ea.badge.dto.RoleDto;
import ea.badge.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
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
    public Collection<RoleDto> getAllRoles() { return this.roleService.getAllRoles().stream()
            .map(role -> mapper.map(role, RoleDto.class)).collect(Collectors.toList());}

    @GetMapping("{id}")
    @Transactional
    public RoleDto getRoleById(@PathVariable("id") Long id){
        return mapper.map(roleService.getRoleById(id), RoleDto.class);
    }
    @PostMapping
    public RoleDto addNewRole(@RequestBody RoleDto role){

        return mapper.map(roleService.addNewRole(mapper.map(role, Role.class)), RoleDto.class);
    }

    @PutMapping
    public RoleDto updateRole(@Valid @RequestBody Role role){
        return mapper.map(roleService.addNewRole(role),RoleDto.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRoleById(@PathVariable Long id){
        if(roleService.existRoleById(id)) {
            roleService.deleteRoleById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
