package byc.springstudy.web;

import byc.springstudy.config.auth.LoginUser;
import byc.springstudy.config.auth.dto.SessionUser;
import byc.springstudy.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ItemsService itemsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("items", itemsService.findAllDesc());
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/items/save")
    public String itemsSave(){
        return "items-save";
    }
}
