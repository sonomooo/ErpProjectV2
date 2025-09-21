package realERPproject.erpProjectVVS.user.UserDto;

import lombok.Getter;

@Getter
public class UserResponse {

    String nickName;
    String loginId;
    String address;

    public UserResponse(String address, String loginId, String nickName) {
        this.address = address;
        this.loginId = loginId;
        this.nickName = nickName;
    }
}
