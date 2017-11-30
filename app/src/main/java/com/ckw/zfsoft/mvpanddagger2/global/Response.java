package com.ckw.zfsoft.mvpanddagger2.global;

/**
 * 服务器返回的对象
 */
public class Response<T> {

    private int code;  //状态码  0：失败  1：成功
    private String msg; // 显示的信息
    private T data; // 业务数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
