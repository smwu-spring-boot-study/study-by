package byc.springstudy;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    SessionUser(){ }

    public SessionUser(User user){
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }

    private String nickname;
    private String email;
}
