package byc.springstudy.domain.items;

import byc.springstudy.domain.BaseTimeEntity;
import byc.springstudy.domain.categoryitems.CategoryItems;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //private Long categoryId;
    @OneToMany(mappedBy = "items")
    private List<CategoryItems> categories = new ArrayList<>();

    @Builder
    public Items(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
        //this.categoryId = categoryId;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
        //this.categoryId = categoryId;
    }
}
