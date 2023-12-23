package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    /**
     * 레파지토리에 단순하게 위임만 하는 클래스이다.
     * 따라서 위임만 하는 것에 대해 만들 필요가 있는가? 고민해볼 필요가 있다.
     * 그래서 컨트롤러에서 레파지토리에 바로 접근하여 써도 문제 없다고 본다.
     */

    private final ItemRepository itemRepository;

    /**
     * 상품 등록
     */
    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /**
     * 상품 전체 조회
     */
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    /**
     * 상품 단건 조회
     */
    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }
}
