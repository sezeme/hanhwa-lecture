package com.sezeme.restapi.section03.valid;

import com.sezeme.restapi.section02.responseentity.ResponseMessage;
import com.sezeme.restapi.section02.responseentity.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<?> findUserByNo(@PathVariable int userNo) {
        boolean check = true;
        if(check) throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
        return ResponseEntity.ok().build();
    }

    /* @Valid : 검증하겠다 라는 의미의 어노테이션을 붙여야 userDTO 내부에 설정해둔 어노테이션이 동작한다. */
    @PostMapping("/users")
    public ResponseEntity<Void> registUser(@Validated @RequestBody UserDTO userDTO) {

        return ResponseEntity.created(URI.create("/valid/users/1")).build();
    }
}
