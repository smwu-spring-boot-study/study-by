package byc.springstudy.domain.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemsRepository  extends JpaRepository<Items, Long> {

    @Query("SELECT i FROM Items i ORDER BY i.id DESC")
    List<Items> findAllDesc();
}
