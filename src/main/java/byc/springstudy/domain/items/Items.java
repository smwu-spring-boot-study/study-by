package byc.springstudy.domain.items;

import byc.springstudy.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Items extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private Long categoryId;

    @Builder
    public Items(String title, String content, String author, Long categoryId){
        this.title = title;
        this.content = content;
        this.author = author;
        this.categoryId = categoryId;
    }

    public void update(String title, String content, Long categoryId){
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }
}
