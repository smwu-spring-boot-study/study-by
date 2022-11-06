package byc.springstudy.domain.category;

import byc.springstudy.domain.items.Items;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private Long depth;

    @ManyToMany
    private Set<Items> items;

    @OneToMany(mappedBy = "parent")
    private List<Category> children = new ArrayList<>();

    public Set<Items> getItems() { return items; }
}
