package com.MusicManager.service;

import java.util.List;

public class ServiceResult {
    private Status status = Status.SUCCESS;
    private String message;
    private Object data;

    public enum Status {
        SUCCESS, FAILED;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setData(Object data){
        this.data = data;
    }

    public Object getData(){
        return data;
    }
}
