package com.sezeme.section02.javaconfig;

import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

import static com.sezeme.section02.javaconfig.Template.getSqlSession;

public class MenuService {

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.selectMenuByMenuCode(menuCode);
        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);
        sqlSession.close();

        return result > 0;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);
        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menuCode);
        sqlSession.close();

        return result > 0;

    }

}
