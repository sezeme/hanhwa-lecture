package com.sezeme.section02.provider;

import com.sezeme.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import static com.sezeme.common.Template.getSqlSession;

public class SqlBuilderService {
    public void registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.insertMenu(menuDTO);

        if(result > 0) {
            sqlSession.commit();
            System.out.println("신규 메뉴 등록 완료");
        } else {
            sqlSession.rollback();
            System.out.println("신규 메뉴 등록 실패");
        }

        sqlSession.close();
    }

    public void modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

        int result = mapper.updateMenu(menuDTO);

        if(result > 0) {
            sqlSession.commit();
            System.out.println("기존 메뉴 수정 완료");
        } else {
            sqlSession.rollback();
            System.out.println("기존 메뉴 수정 실패");
        }

        sqlSession.close();
    }

    public void deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);
        int result = mapper.deleteMenu(menuCode);

        if(result > 0) {
            sqlSession.commit();
            System.out.println("메뉴 삭제 완료");
        } else {
            sqlSession.rollback();
            System.out.println("메뉴 삭제 실패");
        }

        sqlSession.close();
    }
}
