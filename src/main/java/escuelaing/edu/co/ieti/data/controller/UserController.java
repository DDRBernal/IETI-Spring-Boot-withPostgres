package escuelaing.edu.co.ieti.data.controller;

import escuelaing.edu.co.ieti.data.dto.UserDto;
import escuelaing.edu.co.ieti.data.expection.UserNotFoundException;
import escuelaing.edu.co.ieti.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import escuelaing.edu.co.ieti.data.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    User createUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        else throw new UserNotFoundException();
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }


}