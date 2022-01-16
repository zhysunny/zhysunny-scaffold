package com.zhysunny.service;

import com.zhysunny.constant.RoleType;
import com.zhysunny.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhysunny
 * @date 2020/12/20 19:55
 */
@Service
public class UserService {
    private List<User> users = new ArrayList<User>() {{
        add(new User(1L, "admin", RoleType.ADMIN.getRole(), 0, "123456"));
        add(new User(2L, "user", RoleType.USER.getRole(), 0, "123456"));
    }};

    public User info(String username) {
        return users.stream().filter(user -> StringUtils.equals(username, user.getName())).findFirst().orElse(null);
    }

    public boolean match(String username, String password) {
        return Optional.ofNullable(info(username)).filter(user -> StringUtils.equals(password, user.getPassword()))
                .isPresent();
    }

}
