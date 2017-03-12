package com.qs.utils;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/12.
 */
public class JsonStatus implements Serializable {
    private String message;
    private boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
