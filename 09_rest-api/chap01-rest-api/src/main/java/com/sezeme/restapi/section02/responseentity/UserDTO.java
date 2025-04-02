package com.sezeme.restapi.section02.responseentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int no;
    private String id;
    private String pwd;
    private String name;
}
