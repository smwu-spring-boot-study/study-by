package byc.springstudy.domain.category;

import byc.springstudy.domain.categoryitems.CategoryItems;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private Category parent;

    @Column(name = "depth")
    private Integer depth;

    @OneToMany(mappedBy = "category")
    private List<CategoryItems> categoryItems = new ArrayList<>();

    @OneToMany(mappedBy = "parent")
    private List<Category> children = new ArrayList<>();

    //public Set<Items> getItems() { return items; }
}
