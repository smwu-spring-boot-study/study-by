package byc.springstudy.web;

import byc.springstudy.service.ItemsService;
import byc.springstudy.web.dto.ItemsResponseDto;
import byc.springstudy.web.dto.ItemsSaveRequestDto;
import byc.springstudy.web.dto.ItemsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {
    private final ItemsService itemsService;

    @PostMapping("/v1/admin/items")
    public Long save(@RequestBody ItemsSaveRequestDto requestDto){
        return itemsService.save(requestDto);
    }

    @PutMapping("/v1/admin/items/{id}")
    public Long update(@PathVariable Long id, @RequestBody ItemsUpdateRequestDto requestDto){
        return itemsService.update(id, requestDto);
    }

    @GetMapping("/v1/admin/items/{id}")
    public ItemsResponseDto findById(@PathVariable Long id){
        return itemsService.findById(id);
    }
}
