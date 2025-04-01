package com.sezeme.springdatajpa.menu.dto;

/* Spring Data JPA Projection : Repository 계층에서 JPQL 또는 네이티브 쿼리를 작성할 때, 결과를 바로 DTO로 매핑하여 반환
 *    - 변환 단계를 줄여서 쿼리 결과를 바로 필요한 DTO로 받아올 수 있음, 불필요한 데이터를 로딩하지 않아 성능 최적화에 기여
 *    - 단순한 매핑에는 적합하지만, 복잡한 변환이나 다이나믹 로직 적용에는 한계가 있음
 * */
public interface MenuProjection {
    int getMenuCode();
    String getMenuName();
    int getMenuPrice();
    int getCategoryCode();
    String getOrderableStatus();
}
