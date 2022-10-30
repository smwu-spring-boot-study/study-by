package byc.springstudy.web;

import byc.springstudy.config.auth.LoginUser;
import byc.springstudy.config.auth.dto.SessionUser;
import byc.springstudy.service.ItemsService;
import byc.springstudy.web.dto.ItemsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/v1/admin/items/save")
    public String itemsSave(){
        return "items-save";
    }

    @GetMapping("/v1/admin/items/update/{id}")
    public String itemsUpdate(@PathVariable Long id, Model model){
        ItemsResponseDto dto = itemsService.findById(id);
        model.addAttribute("item", dto);

        return "items-update";
    }
}
