package realERPproject.erpProjectVVS.user.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.user.UserDto.UserRequest;
import realERPproject.erpProjectVVS.user.UserDto.UserResponse;
import realERPproject.erpProjectVVS.user.userService.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<ApiResponse<UserResponse>> singUp(@RequestBody UserRequest userRequest){

        UserResponse userResponse = userService.singUp(userRequest);

        return ApiResponse.created(userResponse,"유저를 생성하였습니다");
    }
}
