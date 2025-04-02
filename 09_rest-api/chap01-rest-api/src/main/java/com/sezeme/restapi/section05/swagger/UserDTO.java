package com.sezeme.restapi.section05.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Schema(description = "회원 정보 DTO")
public class UserDTO {
    @Schema(description = "회원번호")
    private int no;
    @Schema(description = "회원 ID")
    private String id;
    @Schema(description = "회원 비밀번호")
    private String pwd;
    @Schema(description = "회원명")
    private String name;
}
