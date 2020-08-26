package com.passion.ds.springboot.jwt.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public enum BooleanTypeEnum {

    /**
     * false
     */
    FALSE(0, "false"),
    /**
     * true
     */
    TRUE(1, "true");


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
            new HashMap<Integer, String>(BooleanTypeEnum.values().length) {{
                for (BooleanTypeEnum mapperEnum : BooleanTypeEnum.values()) {
                    this.put(mapperEnum.getCode(), mapperEnum.getName());
                }
            }};

    public static BooleanTypeEnum valueOf(Integer code) {
        BooleanTypeEnum[] typeEnums = BooleanTypeEnum.values();
        for (BooleanTypeEnum typeEnum : typeEnums) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
