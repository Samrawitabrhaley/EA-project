package ea.badge.controller;

import ea.badge.domain.Member;
import ea.badge.domain.User;
import ea.badge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
//    @GetMapping("/login{username}/{password}")
//    public Member login(@RequestParam String username,@RequestParam String password){
//        return userService.login(username,password);
//    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable  Integer id){
        userService.deleteUser(id);
    }










}
