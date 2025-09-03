package realERPproject.erpProjectVVS.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import realERPproject.erpProjectVVS.user.UserDto.UserRequest;

@Getter
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    String nickName;
    String loginId;
    String password;
    String address;

    public User(String address, String loginId, String nickName, String password) {

        this.address = address;
        this.loginId = loginId;
        this.nickName = nickName;
        this.password = password;
    }

    public void updateFrom(UserRequest req) {
        this.nickName = req.getNickName();
        this.password = req.getPassword();
        this.address  = req.getAddress();
    }
}
