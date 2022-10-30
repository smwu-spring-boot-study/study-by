package byc.springstudy.web.dto;

import byc.springstudy.domain.items.Items;
import lombok.Getter;

@Getter
public class ItemsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public ItemsResponseDto(Items entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
