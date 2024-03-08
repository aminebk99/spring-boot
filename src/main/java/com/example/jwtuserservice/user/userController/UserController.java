package com.example.jwtuserservice.user.userController;

import com.example.jwtuserservice.user.User;
import com.example.jwtuserservice.user.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @PostMapping
    public ResponseEntity<User> saveAllUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<User>> updateUsers(@PathVariable Long id, @RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUsers(id, user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.deleteUserById(id));
    }
}
