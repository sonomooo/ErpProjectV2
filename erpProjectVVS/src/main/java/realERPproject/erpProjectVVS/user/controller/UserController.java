package realERPproject.erpProjectVVS.user.controller;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import realERPproject.erpProjectVVS.user.UserDto.UserRequest;
import realERPproject.erpProjectVVS.user.UserDto.UserResponse;
import realERPproject.erpProjectVVS.user.userService.UserService;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping("/signUp")
    public UserResponse singUp(UserRequest userRequest){

        return userService.singUp(userRequest);
    }
}
