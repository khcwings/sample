package com.multi.sample.common.entity.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

// @JsonIgnoreProperties(ignoreUnknown = true) : 역직렬화(deserialization)에서, 즉, JSON 데이터를 읽어 객체에 매핑해주는 과정에서 객체에는 없는 알 수 없는 property가 JSON 데이터에 있어도 에러를 내뱉지 않고 무시
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSession implements Serializable {
    private static final long serialVersionUID = -5147464770633283258L;

    // 유저 SESSION ID
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
