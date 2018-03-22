package com.perfect.team.service.request.base;

import java.util.Date;

public class BaseRequest {

    private Date date;

    public BaseRequest() {
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
