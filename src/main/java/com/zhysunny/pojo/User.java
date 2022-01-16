package com.zhysunny.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhysunny
 * @date 2020/12/20 20:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String name;

    private String role;

    private int status;

    private String password;
}
