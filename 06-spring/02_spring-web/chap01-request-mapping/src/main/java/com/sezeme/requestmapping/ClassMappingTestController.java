package com.sezeme.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* 클래스 레벨에 @RequestMapping을 설정하면 URL 공통 부분을 이용하는 의미가 된다.
* 내부 핸들러 메소드에 중복 URL를 작성하지 않아도 된다. */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registOrder(Model model) {
        model.addAttribute("message", "GET 방식의 주문 등록 핸들러 메소드 호출");
        return "mappingResult";
    }

    /* 여러 주소 값과 매핑 */
    @RequestMapping(value = {"/modify", "/delete"}, method = RequestMethod.POST)
    public String modifyAndDeleteOrder(Model model) {
        model.addAttribute("message", "POST 방식의 주문 수정, 삭제 핸들러 메소드 호출");
        return "mappingResult";
    }

    /* Path Variable : 요청 주소에 포함 된 변수 */
    @GetMapping("/detail/{orderNo}")
    public String selectOneOrderDetail(Model model, @PathVariable("orderNo") String orderNo) {
        model.addAttribute("message", "GET 방식의 " + orderNo + "주문 상세 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping
    public String otherRequest(Model model) {
        model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비되지 않음");
        return "mappingResult";

    }

}
