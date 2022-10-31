package byc.springstudy.web.dto;

import byc.springstudy.domain.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResultDto {
    private Long id;
    private String title;
    private Long depth;
    private List<CategoryResultDto> children;

    public static CategoryResultDto of(Category category){
        return new CategoryResultDto(
                category.getId(),
                category.getTitle(),
                category.getDepth(),
                category.getChildren().stream().map(CategoryResultDto::of).collect(Collectors.toList())
        );
    }
}
