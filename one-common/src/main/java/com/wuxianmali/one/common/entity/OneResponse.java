package com.wuxianmali.one.common.entity;

import java.util.HashMap;

public class OneResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -6640355222161857345L;

    public OneResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public OneResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public OneResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
