package byc.springstudy.service;

import byc.springstudy.domain.items.Items;
import byc.springstudy.domain.items.ItemsRepository;
import byc.springstudy.web.dto.ItemsResponseDto;
import byc.springstudy.web.dto.ItemsSaveRequestDto;
import byc.springstudy.web.dto.ItemsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        items.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public ItemsResponseDto findById(Long id){
        Items entity = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 물품이 없습니다. id="+id));

        return new ItemsResponseDto(entity);
    }
}
