package com.zhysunny.scaffold.constant;

/**
 * @author zhysunny
 * @date 2020/12/20 20:51
 */
public enum RoleType {
    ADMIN("admin", "管理员"),
    USER("user", "只读"),
    ;

    private String role;

    private String description;

    RoleType(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

}
