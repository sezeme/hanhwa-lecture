package com.sezeme.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public static List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        /* statement에 들어갈 값 : namespace.id */
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public static MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        /* 메소드의 두 번째 인수로 SQL 구문 수행 시 필요한 객체를 전달 */
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", menuCode);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int modifyMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
    }
}
