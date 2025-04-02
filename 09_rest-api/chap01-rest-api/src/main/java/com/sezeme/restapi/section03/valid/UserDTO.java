package com.sezeme.restapi.section03.valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int no;
    @NotNull(message = "아이디는 반드시 입력 되어야 합니다.")
    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    private String id;
    @Length(max = 10, message = "비밀번호는 길이 10을 초과할 수 없습니다.")
    private String pwd;
    @Size(min = 2, message = "이름은 두 글자 이상이어야 합니다.")
    private String name;
}
