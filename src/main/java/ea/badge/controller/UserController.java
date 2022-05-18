package ea.badge.controller;
import ea.badge.domain.User;
import ea.badge.dto.UserDto;
import ea.badge.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    private ModelMapper mapper = new ModelMapper();

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

//        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id){

        return mapper.map(userService.getUserById(id), User.class);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable  Integer id){
        userService.deleteUser(id);
    }








}
