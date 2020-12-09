package com.lppz.cloud.api.entities;


/**
 * 全局的服务返回对象
 */
public class RespData {

    public static final String ERROR_CODE="9999";
    public static final String SUCC_CODE="0000";
    private String code;
    private String msg;
    private Object data;
    public static RespData getDefaultErrRespData() {
        return new RespData(ERROR_CODE,"服务异常");
    }
    public static RespData getDefaultSuccRespData() {
        return new RespData(SUCC_CODE,"服务成功");
    }
    public RespData(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public void setData(Object data) {
        this.data = data;
    }
}
