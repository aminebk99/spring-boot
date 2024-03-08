package com.example.jwtuserservice.user.userService;

import com.example.jwtuserservice.user.User;
import com.example.jwtuserservice.user.userRepository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public String deleteUserById(Long id){
        userRepository.deleteById(id);
        return "User deleted successfuly";
    }
    public Optional<User> updateUsers(Long id, User user){
        // Retrieve existing user by id
        Optional<User> existUser = userRepository.findById(id);

        // Check if user exists
        if (existUser.isPresent()){
            // Get the existing user object
            User newUser = existUser.get();

            // Update user details
            if(user.getFirstname() != null) // Check if firstname is not null
                newUser.setFirstname(user.getFirstname());
            if(user.getLastname() != null) // Check if lastname is not null
                newUser.setLastname(user.getLastname());
            if(user.getEmail() != null) // Check if email is not null
                newUser.setEmail(user.getEmail());
            if(user.getUsername() != null) // Check if username is not null
                newUser.setUsername(user.getUsername());
            if(user.getPassword() != null) // Check if password is not null
                newUser.setPassword(user.getPassword());

            // Save the updated user
            userRepository.save(newUser); // Changed from userRepository.save(user) to userRepository.save(newUser)

            // Return the updated user wrapped in Optional
            return Optional.of(newUser);
        }
        else {
            // Return empty Optional if user doesn't exist
            return Optional.empty();
        }
    }
}
