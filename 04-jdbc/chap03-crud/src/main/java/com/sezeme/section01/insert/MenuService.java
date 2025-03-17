package com.sezeme.section01.insert;

import java.sql.Connection;

import static com.sezeme.common.JDBCTemplate.*;

/* Service 계층 : 비즈니스 로직을 구현하는 계층
* 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
* */
public class MenuService {
    public void registMenu(Menu menu) {
        Connection con = getConnection(); //db와 연동
        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.insertMenu(con, menu); // 정확히 db에 insert되었는지 결과는 받아봄. 필요로 하는 애들을 매개변수로 설정.

        // 연동 결과 관리
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        // 닫기
        close(con);
    }
}
