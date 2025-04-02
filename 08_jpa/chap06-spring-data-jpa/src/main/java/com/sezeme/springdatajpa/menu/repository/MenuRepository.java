package com.sezeme.springdatajpa.menu.repository;

import com.sezeme.springdatajpa.menu.dto.MenuProjection;
import com.sezeme.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // 메뉴 코드를 기준으로 내림차순 정렬한 DTO 프로젝션 반환 메소드
    List<MenuProjection> findAllByOrderByMenuCodeDesc();

    // 전달 받은 가격을 초과하는 메뉴 목록 조회
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    //  전달 받은 가격을 초과하는 메뉴 목록 조회 + 가격 오름차순 조회
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);

    //  전달 받은 가격을 초과하는 메뉴 목록 조회 + 전달 받은 정렬 기준
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);

}
