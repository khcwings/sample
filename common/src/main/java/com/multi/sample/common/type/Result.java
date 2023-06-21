package com.multi.sample.common.type;

public enum Result {

    SUCCESS("0000", "Success"),
    FAIL("9999", "Fail"),
    BAD_REQUEST("1001", "Bad Request"),
    NOT_FOUND("1404", "Not Found"),
    INVALID("9001", "Invalid")
    ;

    public static final String CODE_BAD_REQUEST = "1001";
    public static final String CODE_NOT_FOUND = "1404";
    public static final String CODE_INVALID = "9001";
    private String code;
    private String message;

    Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
