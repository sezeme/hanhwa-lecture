package com.sezeme.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* component를 빈으로 등록한다.
* Dispatcher Servlet은 웹 요처을 받는 증ㄱ시 @Controller 가 달린 컨트롤러 클래스에 처리를 위임한다.
* 그 과정은 컨트롤러 클래스의 핸들러 메서드에 선언 된 다양한 @RequestMapping 설정 내용에 따른다. */
@Controller
public class MethodMappingTestController {

    /* 1. http method 방식을 미지정 */
    @RequestMapping("/menu/regist")
    public String menuRegist(Model model) {
        /* Model 객체에 attribue를 key, value로 추가하면
        * view에서 사용 가능하다. -> chap03-view-resolver에서 자세히 다룸 */
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메서드 호출");

        /* 반환하고자 하는 view 경로를 포함한 이름을 작성한다.
        * resources/templates 하위 부터의 경로를 작성한다.
        * -> chap03-view-resolver 에서 자세히 다룸*/
        return "mappingResult";
    }

    /* 2. http method 방식을 지정 */
    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String menuModify(Model model) {
        model.addAttribute("message" , "GET 방식의 메뉴 수정 핸들러 메소드 호출");
        return "mappingResult";
    }

    /* 3. http method 전용 어노테이션 */
    @GetMapping("/menu/delete")
    public String getMenuDelete(Model model) {
        model.addAttribute("message" , "GET 방식의 메뉴 삭제 핸들러 메소드 호출");
        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postMenuDelete(Model model) {
        model.addAttribute("message" , "POST 방식의 메뉴 삭제 핸들러 메소드 호출");
        return "mappingResult";
    }

}
