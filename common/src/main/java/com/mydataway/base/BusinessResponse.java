package com.mydataway.base;



/**响应类
 * @author calvinkun
 * @date 2019/8/15 11:35
 */
public class BusinessResponse<T> {

    private Integer code;

    private String msg;

    private T data;

    public static BusinessResponse businessResponseFail;

    public static BusinessResponse businessResponseSuccess;

    public static BusinessResponse businessResponseFail(){
        if (businessResponseFail == null) {
            synchronized (BusinessResponse.class){
                if (businessResponseFail == null) {
                    businessResponseFail = new BusinessResponse(CommonResponseEnum.FAIL.getCode(),CommonResponseEnum.FAIL.getmsg());
                }
            }
        }
        return businessResponseFail;
    }

    public static BusinessResponse businessResponseSuccess(){
        if (businessResponseSuccess == null) {
            synchronized (BusinessResponse.class){
                if (businessResponseSuccess == null) {
                    businessResponseSuccess = new BusinessResponse(CommonResponseEnum.SUCCESS.getCode(),CommonResponseEnum.SUCCESS.getmsg());
                }
            }
        }
        return businessResponseSuccess;
    }

    public BusinessResponse() {
    }

    public BusinessResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
