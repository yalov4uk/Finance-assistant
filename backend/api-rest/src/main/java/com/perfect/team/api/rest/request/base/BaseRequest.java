package com.perfect.team.api.rest.request.base;

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
