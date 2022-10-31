package byc.springstudy.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsUpdateRequestDto {
    private String title;
    private String content;
    private Long categoryId;

    @Builder
    public ItemsUpdateRequestDto(String title, String content, Long categoryId){
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }
}
