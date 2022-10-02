package byc.springstudy.config.auth.dto;

import byc.springstudy.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String nickname;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
