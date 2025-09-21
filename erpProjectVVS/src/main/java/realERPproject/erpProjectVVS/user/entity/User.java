package realERPproject.erpProjectVVS.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import realERPproject.erpProjectVVS.user.UserDto.UserRequest;

@Getter
@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;
    private String loginId;
    private String password;
    private String address;

    protected User() {}  // 추가

    public User(String address, String loginId, String nickName, String password) {

        this.address = address;
        this.loginId = loginId;
        this.nickName = nickName;
        this.password = password;
    }

    public void updateFrom(UserRequest req) {
        this.nickName = req.nickName();
        this.password = req.password();
        this.address  = req.address();
    }
}
