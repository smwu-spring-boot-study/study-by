package byc.springstudy.web;

import byc.springstudy.config.auth.LoginUser;
import byc.springstudy.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
