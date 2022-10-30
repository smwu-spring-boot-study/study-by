package byc.springstudy.domain.items;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemsRepositoryTest {

    @Autowired
    ItemsRepository itemsRepository;

    @After
    public void cleanup(){
        itemsRepository.deleteAll();
    }

    @Test
    public void 아이템저장_불러오기(){
        //given
        String title = "테스트 이름";
        String content = "테스트 설명";

        itemsRepository.save(Items.builder()
                        .title(title)
                        .content(content)
                        .author("byunyc124@naver.com")
                        .build());

        //when
        List<Items> itemsList = itemsRepository.findAll();

        //then
        Items items = itemsList.get(0);
        assertThat(items.getTitle()).isEqualTo(title);
        assertThat(items.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2022, 10, 30, 0, 0, 0);
        itemsRepository.save(Items.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .build());

        //when
        List<Items> itemsList = itemsRepository.findAll();

        //then
        Items items = itemsList.get(0);
        System.out.println(">>>>>>>>> createDate="+items.getCreatedDate()+"modifiedDate="+items.getModifiedDate());
        assertThat(items.getCreatedDate()).isAfter(now);
        assertThat(items.getModifiedDate()).isAfter(now);
    }
}
