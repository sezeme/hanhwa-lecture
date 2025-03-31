package com.sezeme.jpql.section03.projection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectionSevice {

    private final ProjectionRepository projectionRepository;

    public ProjectionSevice(ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

    @Transactional
    public List<Menu> singleEntityProjection() {
        List<Menu> menus = projectionRepository.singleEntityProjection();
        menus.get(0).setMenuName("세상에서 제일 맛있는 유니콘 고기");
        // 영속성 컨텍스트에 의해 실제 db에 반영된다.
        return menus;
    }
}
