package com.sezeme.section02.update;

import java.sql.Connection;

import static com.sezeme.common.JDBCTemplate.*;

/* 서비스 단에서 db와의 연결이 이루어짐 */
public class MenuService {
    public void editMenu(Menu menu) {
        Connection con = getConnection();
        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.updateMenu(con, menu);

        if(result > 0) {
            commit(con);
        } else {
            System.out.println("수정 실패!");
            rollback(con);
        }

        close(con);
    }
}
