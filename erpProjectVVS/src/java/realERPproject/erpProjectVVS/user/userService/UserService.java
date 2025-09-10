package realERPproject.erpProjectVVS.user.userService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import realERPproject.erpProjectVVS.user.UserDto.UserRequest;
import realERPproject.erpProjectVVS.user.UserDto.UserResponse;
import realERPproject.erpProjectVVS.user.entity.User;
import realERPproject.erpProjectVVS.user.userRepository.UserRepositoryImpl;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepositoryImpl userRepositoryImpl;

    public UserResponse singUp(UserRequest userRequest){

        User user = new User(
                userRequest.getAddress(),
                userRequest.getLoginId(),
                userRequest.getNickName(),
                userRequest.getPassword());

        User savedUser = userRepositoryImpl.save(user);

        return new UserResponse(
                savedUser.getAddress(),
                savedUser.getLoginId(),
                savedUser.getNickName()
        );
    }

    public UserResponse readUser(UserRequest userRequest){

        User savedUser = userRepositoryImpl.findByloginId(userRequest.getLoginId());

        return new UserResponse(
                savedUser.getAddress(),
                savedUser.getLoginId(),
                savedUser.getNickName()
        );
    }

    public void DeleteUser(User user,
                           String password){

        Optional<User> byId = userRepositoryImpl.findById(user.getId());

        if (password.equals(user.getPassword())){
            userRepositoryImpl.deleteById(user.getId());
        }
    }

    @Transactional
    public UserResponse UserUpdate(UserRequest userRequest) {

        User user = userRepositoryImpl.findByloginId(userRequest.getLoginId());
        user.updateFrom(userRequest);

        return new UserResponse(
                user.getAddress(),
                user.getLoginId(),
                user.getNickName()
        );
    }
}
