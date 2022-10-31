package byc.springstudy.service;

import byc.springstudy.domain.category.CategoryRepository;
import byc.springstudy.web.dto.CategoryResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(rollbackFor = Exception.class)
    public List<CategoryResultDto> getCategoryList(){
        List<CategoryResultDto> results = categoryRepository.findAllCate().stream().map(CategoryResultDto::of).collect(Collectors.toList());
        return results;
    }
}
