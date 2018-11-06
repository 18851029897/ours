package com.ours.common.back;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fish on 2018/7/26.
 */
public class BaseResponse implements Serializable {

    protected boolean success;
    protected String message;
    protected Integer code;
    protected String redirectUrl;
    protected Date date;

    public BaseResponse() {
        this.success = true;
        this.code = Integer.valueOf(1000);
        this.date = new Date();
    }

    public BaseResponse(boolean success) {
        this.success = success;
        this.date = new Date();
    }

    public BaseResponse(boolean success, Integer code) {
        this.success = success;
        this.code = code;
        this.date = new Date();
    }

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.date = new Date();
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.date = new Date();
    }

    public BaseResponse(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.date = new Date();
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public BaseResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public BaseResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return this.code;
    }

    public BaseResponse setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public BaseResponse setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }
}
