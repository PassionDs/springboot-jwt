package com.passion.ds.springboot.jwt.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public enum LockTypeEnum {

    /**
     * 未锁定
     */
    NOT_LOCKED(0, "未锁定"),
    /**
     * 未锁定
     */
    LOCKED(1, "未锁定");


    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static final boolean isType(Integer key) {
        if (TYPE_MAPPER.containsKey(key)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static final Map<Integer, String> getTypeMapper() {
        return TYPE_MAPPER;
    }

    private static final Map<Integer, String> TYPE_MAPPER =
            new HashMap<Integer, String>(LockTypeEnum.values().length) {{
                for (LockTypeEnum mapperEnum : LockTypeEnum.values()) {
                    this.put(mapperEnum.getCode(), mapperEnum.getName());
                }
            }};

    public static LockTypeEnum valueOf(Integer code) {
        LockTypeEnum[] typeEnums = LockTypeEnum.values();
        for (LockTypeEnum typeEnum : typeEnums) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
