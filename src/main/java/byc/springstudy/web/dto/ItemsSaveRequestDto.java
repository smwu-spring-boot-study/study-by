package byc.springstudy.web.dto;

import byc.springstudy.domain.items.Items;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public ItemsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Items toEntity(){
        return Items.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
