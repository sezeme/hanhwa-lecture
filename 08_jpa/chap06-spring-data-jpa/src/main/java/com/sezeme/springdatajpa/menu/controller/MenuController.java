package com.sezeme.springdatajpa.menu.controller;

import com.sezeme.springdatajpa.common.Pagenation;
import com.sezeme.springdatajpa.common.PagingButton;
import com.sezeme.springdatajpa.menu.dto.CategoryDTO;
import com.sezeme.springdatajpa.menu.dto.MenuDTO;
import com.sezeme.springdatajpa.menu.entity.Menu;
import com.sezeme.springdatajpa.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j // log 라는 변수명으로 Logger 객체 타입의 필드가 선언되고 생성 된다.
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
        MenuDTO resultMenu = menuService.findMenuByMenuCode(menuCode);
        model.addAttribute("menu", resultMenu);
        return "menu/detail";
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pageable) {

        /* 페이징 처리 이전 정렬 처리만 반영 된 목록 조회*/
//        List<MenuDTO> menuList = menuService.findMenuList();
//        model.addAttribute("menuList", menuList);

        /* System.out.print 계열의 메소드보다 효율적으로 로그 출력을 할 수 있따.
        * 로그 레벨에 맞춘 메소드를 통해 출력 처리 한다.
        * {} 를 통해 값이 입력 될 위치를 포매팅 한다. */
        log.info("pageable : {}", pageable);

        /* 페이징 처리가 반영 된 목록 조회 */
        Page<MenuDTO> menuList = menuService.findMenuList(pageable);
        PagingButton paging = Pagenation.getPagingButtonInfo(menuList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        log.info("getContent : {}", menuList.getContent());
        log.info("getTotalPages : {}", menuList.getTotalPages());
        log.info("getTotalElements : {}", menuList.getTotalElements());
        log.info("getNumberOfElements : {}", menuList.getNumberOfElements());
        log.info("isFirst : {}", menuList.isFirst());
        log.info("isLast : {}", menuList.isLast());

        return "menu/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer menuPrice, Model model) {
        List<MenuDTO> menuList = menuService.findByMenuPrice(menuPrice);
        model.addAttribute("menuList", menuList);
        return "menu/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {

    }

    @GetMapping("/category")
    @ResponseBody // 응답 데이터의 BODY 에 반환 값을 그대로 전달하겠다는 의미 (ViewResolver 사용 x)
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    @PostMapping("/regist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.registMenu(menuDTO);
        return "redirect:/menu/list";
    }

    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.registMenu(menuDTO);
        return "redirect:/menu/list";
    }
}
