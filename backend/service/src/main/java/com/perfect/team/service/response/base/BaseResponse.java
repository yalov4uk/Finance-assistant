package com.perfect.team.service.response.base;

import java.util.Date;

public class BaseResponse {

    private Date date;

    public BaseResponse() {
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
