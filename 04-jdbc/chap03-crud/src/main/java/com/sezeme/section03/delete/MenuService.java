package com.sezeme.section03.delete;

import java.sql.Connection;

import static com.sezeme.common.JDBCTemplate.*;

public class MenuService {
    public void removeMenu(Menu menu) {
        Connection con = getConnection();
        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.deleteMenu(con, menu);

        if(result > 0){
            commit(con);
        } else {
            System.out.println("삭제 실패!");
            rollback(con);
        }

        close(con);
    }
}
