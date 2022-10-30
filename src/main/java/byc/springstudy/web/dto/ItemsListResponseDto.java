package byc.springstudy.web.dto;

import byc.springstudy.domain.items.Items;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ItemsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public ItemsListResponseDto(Items entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
