package byc.springstudy.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public ItemsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
