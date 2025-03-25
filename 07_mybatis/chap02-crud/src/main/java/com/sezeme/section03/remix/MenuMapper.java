package com.sezeme.section03.remix;

import java.util.List;

public interface MenuMapper {

    public List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByMenuCode(int menuCode);

    int insertMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(int menuCode);
}
