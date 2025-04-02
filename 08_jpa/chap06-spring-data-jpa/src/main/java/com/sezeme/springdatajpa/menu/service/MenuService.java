package com.sezeme.springdatajpa.menu.service;

import com.sezeme.springdatajpa.menu.dto.CategoryDTO;
import com.sezeme.springdatajpa.menu.dto.MenuDTO;
import com.sezeme.springdatajpa.menu.entity.Category;
import com.sezeme.springdatajpa.menu.entity.Menu;
import com.sezeme.springdatajpa.menu.repository.CategoryRepository;
import com.sezeme.springdatajpa.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    /* DTO와 Entity의 분리
    * DTO(Data Transfer Object)는 프레젠테이션 계층과의 데이터 교환을 위한 객체로,
    * 도메인 로직을 담고 있는 Entity 와 분리하여 사용함으로써 보안, 성능, 유지보수 측면의 이점을 얻을 수 있다.
    * 1. 보안 : 민감 데이터/과도 데이터 노출 방지, 과도한 바인딩 공격 방지
    * 2. 성능 : 데이터 전송 최적화, 지연 로딩 문제 완화, 쿼리 최적화
    * 3. 유지 보수 : 명확한 계층 분리(비즈니스 로직 수정이나 도메인 모델 변경이 클라이언트와의 API 계약에 영향 X)
    *               도메인 로직의 캡슐화(Entity 관련 비즈니스 로직은 외부에 노출 X, 클라이언트느 DTO만 이용)
    * 서비스레벨에서 해줌!! */

    /* DTO -Entity 의 변환 방법
    * 1. 수동 매핑 메서드 사용 - 명시적, 로직 짜기 편함. 너무 많은 코드 작성
    * 2. Spring BeanUtils.copyProperties() - 편하지만, 디버깅 어려움
    * 3. ModelMapper 라이브러리 - 편하지만, 디버깅 어려움
    * 4. MapStruct 라이브러리 - 편하지만, 디버깅 어려움
    * 5. Spring Data JPA Projection - 편하지만, 디버깅 어려움 */

    /* 1. findById */
    public MenuDTO findMenuByMenuCode(int menuCode) {
        Menu menu = menuRepository.findById(menuCode)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 2. findAll(Sort) */
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());
        return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).toList();
    }

    /* 3. findAll(Pageable) */
    public Page<MenuDTO> findMenuList(Pageable pageable) {

        /* page 0부터 시작하는 부분을 1로 보정
        * 정렬 기준은 전달 받지 않고 고정된 기준으로 수행 */
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending()
        );

        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    /* 4. 쿼리 메소드 사용 */
    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {
//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);
//        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(
                menuPrice, Sort.by("menuPrice").descending());

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* 5. JPQL or Native Query */
    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }

    /* 6. save : 엔터티 저장 */
    @Transactional
    public void registMenu(MenuDTO menuDTO) {
        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }

    /* 수정 : 엔티티 객체의 필드 값을 수정, 트랜잭션 종료 시 자동 flush */
    @Transactional
    public void modifyMenu(MenuDTO menuDTO) {
        Menu foundMenu = menuRepository.findById(menuDTO.getMenuCode())
                .orElseThrow(IllegalArgumentException::new);

        // setter 를 기계적으로 만들어 놓으면 엔터티 객체가 수정에 열린 상태가 되므로
        // 필요한 기능에 맞춘 메소드를 별도로 구현해서 수정한다.
        foundMenu.modifyMenuName(menuDTO.getMenuName());
    }

    /* 8. delete */
    @Transactional
    public void deleteMenu(int menuCode) {
        menuRepository.deleteById(menuCode);
    }
}
