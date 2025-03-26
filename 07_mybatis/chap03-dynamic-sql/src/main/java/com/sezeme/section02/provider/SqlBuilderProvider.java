package com.sezeme.section02.provider;

import com.sezeme.common.MenuDTO;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilderProvider {
    public String insertMenu(MenuDTO menuDTO) {
        return new SQL()
                .INSERT_INTO("tbl_menu")
                .VALUES("menu_name", "#{ menuName }")
                .VALUES("menu_price", "#{ menuPrice }")
                .VALUES("category_code", "#{ categoryCode }")
                .VALUES("orderable_status", "#{ orderableStatus }")
                .toString();
    }

    public String updateMenu(MenuDTO menuDTO) {
        SQL sql = new SQL()
                .UPDATE("tbl_menu");
        if (menuDTO.getMenuName() != null && !menuDTO.getMenuName().isEmpty()) {
            sql.SET("menu_name = #{ menuName }");
        } else if (menuDTO.getMenuPrice() != 0){
            sql.SET("menu_price = #{ menuPrice }");
        } else if (menuDTO.getCategoryCode() != 0){
            sql.SET("category_code = #{ categoryCode }");
        } else if (menuDTO.getOrderableStatus() != null && !menuDTO.getOrderableStatus().isEmpty()){
            sql.SET("orderable_status = #{ orderableStatus }");
        }
        sql.WHERE("menu_code = #{ menuCode }");
        return sql.toString();
    }

    public String deleteMenu() {
        return new SQL()
                .DELETE_FROM("tbl_menu")
                .WHERE("menu_code = #{ menuCode }")
                .toString();
    }
}
