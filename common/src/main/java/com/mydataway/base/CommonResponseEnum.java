package com.mydataway.base;

/**响应码
 * @author calvinkun
 * @date 2019/7/10 21:42
 */
public enum CommonResponseEnum {

    SUCCESS(200,"success"),
    FAIL(500,"fail"),
    INIT_FAIL(1001, "授权失败"),
    DELETE_FAIL(510,"删除失败");

    private int code;
    private String msg;

    CommonResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }
}
