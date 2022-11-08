package byc.springstudy.domain.categoryitems;

import byc.springstudy.domain.category.Category;
import byc.springstudy.domain.items.Items;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CategoryItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "items_id")
    private Items items;
}
