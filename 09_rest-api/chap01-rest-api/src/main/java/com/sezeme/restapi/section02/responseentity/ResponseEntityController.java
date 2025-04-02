package com.sezeme.restapi.section02.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/entity")
public class ResponseEntityController {

    private List<UserDTO> users;

    public ResponseEntityController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(3, "user03", "pass03", "이순신"));
    }

    @GetMapping("/users") // 꺽쇠 안에 body 의 타입이 들어감
    public ResponseEntity<ResponseMessage> findAllUsers() {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요할 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );
        /* 응답 바디 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        /* 응답 메시지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );

        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/user/{userNo}") // 꺽쇠 안에 body 의 타입이 들어감
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요할 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );
        /* 응답 바디 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo)
                        .findFirst().get();
        responseMap.put("user", foundUser);

        /* 응답 메시지 설정 */
        ResponseMessage responseMessage = new ResponseMessage(
                200, "조회 성공", responseMap
        );

        return new ResponseEntity<>(responseMessage, httpHeaders, HttpStatus.OK);
/*        return ResponseEntity
                .ok()
                .header(httpHeaders)
                .body(new ResponseMessage(200, "조회 성공", responseMap));*/
    }

    @PostMapping("/users") // body 에 들어갈 값이 없는 경우
    public ResponseEntity<Void> registerUser(@RequestBody UserDTO userDTO) {
        int lastUserNo = users.get(users.size() - 1).getNo();
        userDTO.setNo(lastUserNo + 1);
        users.add(userDTO);

        return ResponseEntity
                .created(URI.create("/entity/users/" + users.get(users.size() - 1).getNo()))
                .build();
    }

    @PutMapping("/user/{userNo}") // 꺽쇠 안에 body 의 타입이 들어감
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo, @RequestBody UserDTO userDTO) {
        // json으로 req body 가 들어온다면 UserDTO 로 convert 해서 들어와야 함
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo)
                .findFirst().get();
        foundUser.setPwd(userDTO.getPwd());
        foundUser.setName(userDTO.getName());

        return ResponseEntity.created(URI.create("/entity/users/" + userNo)).build();
    }

    @DeleteMapping("/user/{userNo}") // 꺽쇠 안에 body 의 타입이 들어감
    public ResponseEntity<Void> removeUser(@PathVariable int userNo) {
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo)
                .findFirst().get();
        users.remove(foundUser);
        /* noContent() : 상태 코드 중 하나 */
        return ResponseEntity.noContent().build();
    }
}
