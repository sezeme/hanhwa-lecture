package com.sezeme.section01.xml;

import com.sezeme.common.MenuDTO;
import com.sezeme.common.SearchCriteria;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DynamicSqlMapper {
    List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(Map<String, Set<Integer>> randomMenuCodeList);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);
}
