package byc.springstudy.service;

import byc.springstudy.domain.items.Items;
import byc.springstudy.domain.items.ItemsRepository;
import byc.springstudy.web.dto.ItemsListResponseDto;
import byc.springstudy.web.dto.ItemsResponseDto;
import byc.springstudy.web.dto.ItemsSaveRequestDto;
import byc.springstudy.web.dto.ItemsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ItemsService {
    private final ItemsRepository itemsRepository;

    @Transactional
    public Long save(ItemsSaveRequestDto requestDto){
        return itemsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ItemsUpdateRequestDto requestDto){
        Items items = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 물품이 없습니다. id="+id));
        items.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getCategoryId());

        return id;
    }

    public ItemsResponseDto findById(Long id){
        Items entity = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 물품이 없습니다. id="+id));

        return new ItemsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ItemsListResponseDto> findAllDesc(){
        return itemsRepository.findAllDesc().stream().map(ItemsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Items items = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. id="+id));

        itemsRepository.delete(items);
    }
}
