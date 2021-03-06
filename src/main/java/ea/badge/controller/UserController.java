package ea.badge.controller;


import ea.badge.domain.Member;
import ea.badge.domain.User;
import ea.badge.dto.MemberDto;
import ea.badge.dto.UserDto;
import ea.badge.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Collection<UserDto> getAllUsers(){

        return this.userService.getAllUsers().stream()
                .map(transaction -> mapper.map(transaction, UserDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto user){
        return mapper.map(userService.addUser(mapper.map(user,
                User.class)), UserDto.class);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){

        return mapper.map(userService.getUserById(id), User.class);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable  Long id){
        userService.deleteUser(id);
    }

    @RolesAllowed("admin")
    @PostMapping("/login")
        public MemberDto login(@RequestBody UserDto userDto){
        String username=userDto.getUsername();
        String password=userDto.getPassword();
        System.out.println("Get params "+ username +" passwor :"+password);
        return mapper.map(userService.login(username,password),MemberDto.class);

    }
}
