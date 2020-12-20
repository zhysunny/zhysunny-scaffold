package com.zhysunny.scaffold.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhysunny
 * @date 2020/12/12 11:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hello {
    private String name;

    private int port;
}
