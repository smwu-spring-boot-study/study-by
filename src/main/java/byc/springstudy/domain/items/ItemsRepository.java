package byc.springstudy.domain.items;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository  extends JpaRepository<Items, Long> {
}
