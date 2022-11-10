package byc.springstudy;

import byc.springstudy.domain.category.Category;
import byc.springstudy.domain.category.CategoryRepository;
import byc.springstudy.domain.user.Role;
import byc.springstudy.domain.user.User;
import byc.springstudy.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.userDBInit();
        initService.categoryDBInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final UserRepository userRepository;
        private final CategoryRepository categoryRepository;
        public void userDBInit(){
            List<User> userList = userRepository.findAll();
            if(userList.size() == 0){
                User user = User.builder()
                        .email("byunyc124@naver.com")
                        .name("변영채")
                        .role(Role.ADMIN)
                        .build();
                userRepository.save(user);
            }
        }

        /*
        insert into CATEGORY(DEPTH, TITLE) values(1, '국내');
        insert into CATEGORY(DEPTH, TITLE) values(1, '해외');
        insert into CATEGORY(DEPTH, TITLE, PARENT) values(2, '국내시', 1);
        insert into CATEGORY(DEPTH, TITLE, PARENT) values(2, '해외시', 2);
        insert into CATEGORY(DEPTH, TITLE, PARENT) values(2, '국내소설', 1);
        insert into CATEGORY(DEPTH, TITLE, PARENT) values(2, '해외소설', 2);
        */
        public void categoryDBInit(){
            Category category1 = Category.builder()
                    .title("국내")
                    .depth(1)
                    .build();
            Category category2 = Category.builder()
                    .title("해외")
                    .depth(1)
                    .build();
            categoryRepository.save(category1);
            categoryRepository.save(category2);

            //Category c1 = categoryRepository.findById(category1.getId());
            List<Category> categoryList = categoryRepository.findAllCate();
            Category c1 = categoryList.get(0);
            Category c2 = categoryList.get(1);

            Category category3 = Category.builder()
                    .title("국내시")
                    .depth(2)
                    .parent(c1)
                    .build();
            Category category4 = Category.builder()
                    .title("해외시")
                    .depth(2)
                    .parent(c2)
                    .build();
            Category category5 = Category.builder()
                    .title("국내소설")
                    .depth(2)
                    .parent(c1)
                    .build();
            Category category6 = Category.builder()
                    .title("해외소설")
                    .depth(2)
                    .parent(c2)
                    .build();
            categoryRepository.save(category3);
            categoryRepository.save(category4);
            categoryRepository.save(category5);
            categoryRepository.save(category6);
        }
    }
}
