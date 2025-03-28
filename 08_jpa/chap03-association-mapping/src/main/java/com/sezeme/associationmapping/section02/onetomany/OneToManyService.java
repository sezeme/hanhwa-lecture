package com.sezeme.associationmapping.section02.onetomany;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OneToManyService {

    private OneToManyRepository oneToManyRepository;

    public OneToManyService(OneToManyRepository oneToManyRepository) {
        this.oneToManyRepository = oneToManyRepository;
    }

    @Transactional
    public Category findCategory(int categoryCode) {
        Category category = oneToManyRepository.find(categoryCode);
//        System.out.println("[category printed ] " + category);

        return category;
    }

    @Transactional
    public void registMenu(CategoryDTO categoryInfo) {
        Category category = new Category(
                categoryInfo.getCategoryCode(),
                categoryInfo.getCategoryName(),
                categoryInfo.getRefCategoryCode(),
                null
        );
        Menu menu = new Menu(
                categoryInfo.getMenuList().get(0).getMenuCode(),
                categoryInfo.getMenuList().get(0).getMenuName(),
                categoryInfo.getMenuList().get(0).getMenuPrice(),
                categoryInfo.getMenuList().get(0).getCategoryCode(),
                categoryInfo.getMenuList().get(0).getOrderableStatus()
        );
        List<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        category.setMenuList(menuList);

        oneToManyRepository.regist(category);
    }
}