package com.ours.common.back;

/**
 * Created by fish on 2018/7/26.
 */
public class DataResponse extends BaseResponse {

    protected Object data;

    public DataResponse() {
    }

    public DataResponse(boolean success) {
        super(success);
    }

    public DataResponse(boolean success, Object data) {
        super(success);
        this.data = data;
    }

    public DataResponse(Integer code, String message) {
        super(code, message);
    }

    public DataResponse(Integer code, Object data) {
        super(true, code);
        this.data = data;
    }

    public DataResponse(Integer code, String message, Object data) {
        super(code, message);
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
